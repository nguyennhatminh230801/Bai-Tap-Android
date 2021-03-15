package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnSubmit, btnRead;
    CheckBox chkBox;
    SQLHelper sqlHelper;
    List<Account> list;
    static final String SHAREPRE_NAME = "Account";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        sqlHelper = new SQLHelper(this);

        sqlHelper.insertAccount(new Account("Hello", "Bye"));
        sqlHelper.insertAccount(new Account("Hello1", "Bye1"));
        sqlHelper.insertAccount(new Account("Hello2", "Bye2"));
        sqlHelper.insertAccount(new Account("Hello3", "Bye3"));

        list = sqlHelper.getAllAccount();
        Log.d("test", "onCreate: " + list.size());
//        sqlHelper.deleteAccount(5);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkBox.isChecked()) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHAREPRE_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("username", String.valueOf(edtUsername.getText()));
                editor.putString("password", String.valueOf(edtPassword.getText()));
                editor.commit();

                Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHAREPRE_NAME, MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "null");
                String password = sharedPreferences.getString("password", "null");
                Toast.makeText(MainActivity.this, username + ", " + password, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Anhxa()
    {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        chkBox = findViewById(R.id.chkBox);
        btnRead = findViewById(R.id.btnRead);
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences(SHAREPRE_NAME, MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "null");
        String password = sharedPreferences.getString("password", "null");
        Toast.makeText(MainActivity.this, username + ", " + password, Toast.LENGTH_SHORT).show();
    }
}