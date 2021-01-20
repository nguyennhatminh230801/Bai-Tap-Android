package com.example.baitapandroidbuoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private Button Button0;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private Button Button6;
    private Button Button7;
    private Button Button8;
    private Button Button9;
    
    private TextView ShowOperator;
    private TextView ShowAnswer;
    
    private Button ButtonC;
    private Button ButtonDEL;

    private Button ButtonDivide;
    private Button ButtonMinus;
    private Button ButtonPlus;
    private Button ButtonMultiply;

    private Button DoiDau;
    private Button ButtonFloat;

    private Button ButtonEquals;

    float value1, value2;
    boolean isPlus = false, isDevide = false, isMultiply = false, isMinus = false;
    String LuuSo = "";


    public void Mapping()
    {
        Button0 = (Button) findViewById(R.id.Button0);
        Button1 = (Button) findViewById(R.id.Button1);
        Button2 = (Button) findViewById(R.id.Button2);
        Button3 = (Button) findViewById(R.id.Button3);
        Button4 = (Button) findViewById(R.id.Button4);
        Button5 = (Button) findViewById(R.id.Button5);
        Button6 = (Button) findViewById(R.id.Button6);
        Button7 = (Button) findViewById(R.id.Button7);
        Button8 = (Button) findViewById(R.id.Button8);
        Button9 = (Button) findViewById(R.id.Button9);

        ShowOperator = (TextView) findViewById(R.id.ShowOperator);
        ShowAnswer = (TextView) findViewById(R.id.ShowAnswer);


        ButtonC = (Button) findViewById(R.id.ButtonC);
        ButtonDEL = (Button) findViewById(R.id.ButtonDEL);

        ButtonDivide = (Button) findViewById(R.id.ButtonDivide);
        ButtonMinus = (Button) findViewById(R.id.ButtonMinus);
        ButtonPlus = (Button) findViewById(R.id.ButtonPlus);
        ButtonMultiply = (Button) findViewById(R.id.ButtonMultiply);

        DoiDau = (Button) findViewById(R.id.DoiDau);
        ButtonFloat = (Button) findViewById(R.id.ButtonFloat);

        ButtonEquals = (Button) findViewById(R.id.ButtonEquals);
    }

    public void Solving()
    {
        Button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "0");
                LuuSo += "0";
            }
        });

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "1");
                LuuSo += "1";
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "2");
                LuuSo += "2";
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "3");
                LuuSo += "3";
            }
        });

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "4");
                LuuSo += "4";
            }
        });

        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "5");
                LuuSo += "5";
            }
        });

        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "6");
                LuuSo += "6";
            }
        });

        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "7");
                LuuSo += "7";
            }
        });

        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "8");
                LuuSo += "8";
            }
        });

        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "9");
                LuuSo += "9";
            }
        });

        DoiDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText("-" + ShowOperator.getText());
                LuuSo = "-" + LuuSo;
            }
        });
        ButtonFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + ".");
                LuuSo += ".";
            }
        });

        ButtonDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = ShowOperator.getText().toString().length();
                String res = ShowOperator.getText().toString();

                int size2 = LuuSo.length();

                String newstr = "";
                String newstr2 = "";

                for(int i = 0 ; i < size - 1 ; i++)
                {
                    newstr += res.charAt(i);
                }

                for(int i = 0 ; i < size2 - 1 ; i++)
                {
                    newstr2 += LuuSo.charAt(i);
                }

                LuuSo = newstr2;
                ShowOperator.setText(newstr);
            }
        });

        ButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText("");
                ShowAnswer.setText("");
                LuuSo = "";
                value1 = 0f;
                value2 = 0f;
                isPlus = false;
                isMinus = false;
                isDevide = false;
                isMultiply = false;
            }
        });

        ButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "+");
                value1 = Float.parseFloat(LuuSo);
                LuuSo = "";
                isPlus = true;
            }
        });

        ButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "-");
                value1 = Float.parseFloat(LuuSo);
                LuuSo = "";
                isMinus = true;
            }
        });

        ButtonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "/");
                value1 = Float.parseFloat(LuuSo);
                LuuSo = "";
                isDevide = true;
            }
        });

        ButtonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowOperator.setText(ShowOperator.getText() + "*");
                value1 = Float.parseFloat(LuuSo);
                LuuSo = "";
                isMultiply = true;
            }
        });

        ButtonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value2 = Float.parseFloat(LuuSo);

                if (isPlus == true){
                    ShowAnswer.setText(value1 + value2 + "");
                }

                if(isMinus == true) {
                    ShowAnswer.setText(value1 - value2 + "");
                }

                if(isMultiply == true) {
                    ShowAnswer.setText(value1 * value2 + "");
                    //isMultiply = false;
                }

                if(isDevide == true){
                    if(value2 == 0f)
                    {
                        ShowAnswer.setText("Không được chia cho 0");
                    }
                    else
                    {
                        ShowAnswer.setText(value1 / value2 + "");
                        //isDevide = false;
                    }
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();
        Solving();
    }


}