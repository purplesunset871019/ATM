package com.example.frank.atm2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GenderActivity extends AppCompatActivity {

    private EditText ed_gender;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }

    public void next(View view){
        ed_gender = findViewById(R.id.ed_gender);
        gender = ed_gender.getText().toString();
        getSharedPreferences("atm",MODE_PRIVATE)
                .edit()
                .putString("GENDER",gender)
                .apply();
        setResult(RESULT_OK);

        Intent main = new Intent(this, MainActivity.class);
        setResult(RESULT_OK);
        main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(main);
    }

    public void back(View view){
        finish();
    }
}
