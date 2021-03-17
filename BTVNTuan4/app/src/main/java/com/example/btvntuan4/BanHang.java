package com.example.btvntuan4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BanHang extends AppCompatActivity {
    TextView HelloUser;
     String username;
    List<Product> list, listBuy;
    RecyclerView RCBanHang;
    TextView TotalAmount, TotalMoney;
    ImageView btnBuy;
    public void getMappingItemActivity2()
    {
        list = new ArrayList<>();
        TotalAmount = findViewById(R.id.TotalAmmount);
        TotalMoney = findViewById(R.id.TotalMoney);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_hang);

        Intent intent = getIntent();
        username = intent.getStringExtra("Username");

        Toast.makeText(getBaseContext(), "Xin chào," + username, Toast.LENGTH_SHORT).show();

        list.add(new Product(R.drawable.icon_fifaonline_4pc, "Fifa Online 4", 25000, 0, R.drawable.increase_item, R.drawable.decrese_item));
        list.add(new Product(R.drawable.icon_fifaonline_4mobile, "Fifa Online 4 Mobile", 30000, 0, R.drawable.increase_item, R.drawable.decrese_item));
        list.add(new Product(R.drawable.icon_blade_and_soul, "Blade And Soul", 35000, 0, R.drawable.increase_item, R.drawable.decrese_item));
        list.add(new Product(R.drawable.icon_league_of_legend, "Liên Minh Huyền Thoại", 40000, 0, R.drawable.increase_item, R.drawable.decrese_item));
        list.add(new Product(R.drawable.icon_arena_of_valor, "Liên Quân Mobile", 45000, 0, R.drawable.increase_item, R.drawable.decrese_item));
        list.add(new Product(R.drawable.icon_free_fire, "Free Fire", 20000, 0, R.drawable.increase_item, R.drawable.decrese_item));

        BanHangAdapter banHangAdapter = new BanHangAdapter(list, BanHang.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BanHang.this, RecyclerView.VERTICAL, false);
        RCBanHang.setLayoutManager(layoutManager);
        RCBanHang.setAdapter(banHangAdapter);

        banHangAdapter.setiOnClickItemProduct(new IOnClickItemProduct() {
            @Override
            public void onClickIncreaseButton(Product product) {
                int NowAmount = Integer.parseInt(TotalAmount.getText().toString());
                int NowMoney = Integer.parseInt(TotalMoney.getText().toString());
                int Price1 = Integer.parseInt(product.getPrice() + "");

                NowAmount++;
                NowMoney += Price1;

                TotalAmount.setText(String.valueOf(NowAmount));
                TotalMoney.setText(String.valueOf(NowMoney));

                if(listBuy.contains(product))
                {
                    product.setAmount(product.getAmount() + 1);
                    banHangAdapter.notifyDataSetChanged();
                }
                else{
                    listBuy.add(product);
                    product.setAmount(product.getAmount() + 1);
                    banHangAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onClickDecreaseButton(Product product) {
                int NowAmount = Integer.parseInt(TotalAmount.getText().toString());
                int NowMoney = Integer.parseInt(TotalMoney.getText().toString());
                int Price1 = product.getPrice();

                if(NowAmount == 0)
                {
                    Toast.makeText(getBaseContext(), "Không thể giảm trừ", Toast.LENGTH_SHORT).show();
                }
                else {
                    NowAmount--;
                    NowMoney -= Price1;

                    TotalAmount.setText(String.valueOf(NowAmount));
                    TotalMoney.setText(String.valueOf(NowMoney));
                }

                if(listBuy.contains(product)){
                    product.setAmount(product.getAmount() - 1);
                    banHangAdapter.notifyDataSetChanged();
                }

            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(BanHang.this, CartOrder.class);
                intent1.putExtra("TotalPrice", TotalMoney.getText().toString());
                intent1.putParcelableArrayListExtra("listBuy", (ArrayList<? extends Parcelable>) listBuy);
                startActivity(intent1);
            }
        });
    }
}