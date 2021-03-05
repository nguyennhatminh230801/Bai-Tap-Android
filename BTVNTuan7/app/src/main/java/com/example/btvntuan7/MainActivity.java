package com.example.btvntuan7;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.inputmethod.EditorInfo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.toolbox.JsonArrayRequest;

import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView Covid19RC;
    List<Covid19> list = new ArrayList<>();
    Covid19Adapter adapter;
    String APICovid19 = "https://ncov.trungbt.xyz/countries";
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        Covid19RC = findViewById(R.id.Covid19RC);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, APICovid19, null
                , response -> {
                    try {
                        for(int i = 0 ; i < response.length() ; i++)
                        {
                            JSONObject jsonObject1 = response.getJSONObject(i);

                            String countries = jsonObject1.getString("Country_Region");
                            String confirmed = jsonObject1.getString("Confirmed");
                            String deaths = jsonObject1.getString("Deaths");
                            String recovered = jsonObject1.getString("Recovered");

                            list.add(new Covid19(countries, confirmed, deaths, recovered));
                        }

                        adapter = new Covid19Adapter(list, MainActivity.this);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        Covid19RC.setLayoutManager(layoutManager);
                        Covid19RC.setAdapter(adapter);

                        searchView = findViewById(R.id.findCountries);
                        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
                        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {
                                adapter.getFilter().filter(query);
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(String newText) {
                                adapter.getFilter().filter(newText);
                                return false;
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.e("TAG", "Thành Công");
                }, error -> Log.e("TAG", "Thất Bại"));

        requestQueue.add(jsonArrayRequest);

    }

    @Override
    public void onBackPressed() {
        if(!searchView.isIconified())
        {
            searchView.setIconified(true);
        }
        super.onBackPressed();
    }
}