package com.example.hello.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hello.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button  btn_route, btn_favorites, btn_arround,  btn_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_route = findViewById(R.id.btn_route);
        btn_favorites = findViewById(R.id.btn_favorites);
        btn_arround = findViewById(R.id.btn_arround);
        btn_share = findViewById(R.id.btn_location);

        btn_arround.setOnClickListener(this);
        btn_route.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        btn_favorites.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id_v = v.getId();
        Intent intent = new Intent(HomeActivity.this, FragmentActivity.class);

        switch (id_v){
            case R.id.btn_arround:
                intent.putExtra("name", "arround");
                break;
            case R.id.btn_route:
                intent.putExtra("name", "route");
                break;
            case R.id.btn_favorites:
                intent.putExtra("name", "favorite");
                break;
            case R.id.btn_location:
                intent.putExtra("name", "location");
                break;
        }
        startActivity(intent);
    }
}