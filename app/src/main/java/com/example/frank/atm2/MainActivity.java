package com.example.frank.atm2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!login){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,RC_LOGIN);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode!= RESULT_OK){
                finish();
            }

            else{
                login = true;

                if(user.isValid()){
                    Intent nick = new Intent(this,NicknameActivity.class);
                    startActivity(nick);
                }

            }
        }
    }
}
