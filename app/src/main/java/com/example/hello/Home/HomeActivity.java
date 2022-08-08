package com.example.hello.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hello.Home.Arround.ArroundActivity;
import com.example.hello.Home.Favorites.FavoriteActivity;
import com.example.hello.Home.LocationShare.LocationActivity;
import com.example.hello.Home.Route.RouteActivity;
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
        Intent intent;
        switch (v.getId()){
            case R.id.btn_arround:
                intent = new Intent(getApplicationContext(), ArroundActivity.class);
            case R.id.btn_route:
                intent = new Intent(getApplicationContext(), RouteActivity.class);
            case R.id.btn_favorites:
                intent = new Intent(getApplicationContext(), FavoriteActivity.class);
            case R.id.btn_location:
                intent = new Intent(getApplicationContext(), LocationActivity.class);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
        startActivity(intent);
    }
}