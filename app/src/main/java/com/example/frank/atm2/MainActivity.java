package com.example.frank.atm2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;
    List<String> fruits = Arrays.asList("芭樂","香蕉","蘋果");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!login){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,RC_LOGIN);
        }




        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FruitAdapter());


        //listview();
    }

    class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {
        @NonNull
        @Override
        public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            View view = LayoutInflater.from(context)
                    .inflate(android.R.layout.simple_list_item_1,parent,false);
            FruitViewHolder fruitViewHolder = new FruitViewHolder(view);
            return fruitViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
            holder.fruitname.setText(fruits.get(position));
        }

        @Override
        public int getItemCount() {
            return fruits.size();
        }

        class FruitViewHolder extends RecyclerView.ViewHolder{
            TextView fruitname;
            public FruitViewHolder(View itemView) {
                super(itemView);
                fruitname = itemView.findViewById(android.R.id.text1);
            }
        }
    }


    private void listview() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
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

                if(!user.isValid()){
                    Intent nick = new Intent(this,NicknameActivity.class);
                    startActivity(nick);
                }

            }
        }
    }
}
