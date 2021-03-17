package com.example.btvntuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin, btnRegister;
    String username, password;
    String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$";
    List<Account> accountsLogin;
    Dialog RegisterForm;
    EditText RegisterUsername, RegisterPassword, RegisterRePassword;
    Button btnRegisterDialog;

    public void getMappingItem()
    {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }

    public void InitializeRegisterDialog()
    {
        RegisterForm = new Dialog(this);
        RegisterForm.setContentView(R.layout.dialog_register_account);
    }

    public boolean SuccessLogin(String username, String password)
    {
        if(username.length() == 0)
        {
            Toast.makeText(getBaseContext(), "Không được để trống tên tài khoản", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(password.length() == 0)
        {
            Toast.makeText(getBaseContext(), "Không được để trống mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!Pattern.compile(REGEX).matcher(password).matches())
        {
            Toast.makeText(getBaseContext(), "Mật Khẩu Phải Có chữ số, có chữ cái thường và ít nhất 8 kí tự", Toast.LENGTH_SHORT).show();
            return false;
        }

        for(Account account : accountsLogin){
            if(account.username.compareTo(username) == 0 && account.password.compareTo(password) == 0){
                return true;
            }
            if(account.username.compareTo(username) == 0 && account.password.compareTo(password) != 0){
                Toast.makeText(getBaseContext(), "Bạn đã nhập sai mật khẩu", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        Toast.makeText(getBaseContext(), "Tài Khoản Chưa Được Đăng Ký", Toast.LENGTH_SHORT).show();
        return false;
    }

    public boolean SuccessRegister(String username, String password, String RePassword){
        if(username.length() == 0){
            Toast.makeText(getBaseContext(), "Không được để trống tên tài khoản", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(password.length() == 0){
            Toast.makeText(getBaseContext(), "Không được để trống mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(RePassword.length() == 0){
            Toast.makeText(getBaseContext(), "Không được để trống mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.compareTo(RePassword) != 0)
        {
            Toast.makeText(getBaseContext(), "Mật khẩu không trùng nhau", Toast.LENGTH_SHORT).show();
            return false;
        }

        for(Account account : accountsLogin){
            if(account.username.compareTo(username) == 0){
                Toast.makeText(getBaseContext(), "Tài Khoản Đã Tồn Tại", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getMappingItem();
        InitializeRegisterDialog();

        accountsLogin = new ArrayList<>();

        btnLogin.setOnClickListener(v -> {
            username = edtUsername.getText().toString().trim();
            password = edtPassword.getText().toString().trim();

            if(SuccessLogin(username, password))
            {
                Toast.makeText(getBaseContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, BanHang.class);
                intent.putExtra("Username", username);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(v -> {
            RegisterUsername = RegisterForm.findViewById(R.id.edtUsernameDialog);
            RegisterPassword = RegisterForm.findViewById(R.id.edtPasswordDialog);
            RegisterRePassword = RegisterForm.findViewById(R.id.edtRePasswordDialog);
            btnRegisterDialog = RegisterForm.findViewById(R.id.btnRegisterDialog);

            btnRegisterDialog.setOnClickListener(v1 -> {
                String username1 = RegisterUsername.getText().toString().trim();
                String password1 = RegisterPassword.getText().toString().trim();
                String password2 = RegisterRePassword.getText().toString().trim();

                if(SuccessRegister(username1, password1, password2)){
                    Toast.makeText(getBaseContext(), "Đăng Ký Thành Công", Toast.LENGTH_LONG).show();
                    accountsLogin.add(new Account(username1, password1));
                    RegisterForm.dismiss();
                }
            });

            RegisterForm.show();
        });
    }
}