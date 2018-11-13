package com.example.frank.atm2;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText ed_username;
    private EditText ed_password;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edusername = findViewById(R.id.ed_username);
        String username = getSharedPreferences("atm",MODE_PRIVATE)
                .getString("USERNAME","");
        edusername.setText(username);
    }

    public void Login(View view){
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        username = ed_username.getText().toString();
        password = ed_password.getText().toString();
        if("Frank".equals(username) && "123456789".equals(password)){
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("USERNAME",username)
                    .apply();
            setResult(RESULT_OK);
            finish();
        }

        else{
            new AlertDialog.Builder(this)
                    .setTitle("ATM")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK",null)
                    .show();

        }
    }
}
