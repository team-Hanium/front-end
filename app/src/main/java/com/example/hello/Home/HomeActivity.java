package com.example.hello.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hello.Home.Arround.ArroundFragment;
import com.example.hello.Home.Favorites.FavoriteFragment;
import com.example.hello.Home.LocationShare.LocationFragment;
import com.example.hello.Home.Route.RouteFragment;
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
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (v.getId()){
            case R.id.btn_arround:
                fragment = new ArroundFragment();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            case R.id.btn_route:
                fragment = new RouteFragment();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            case R.id.btn_favorites:
                fragment = new FavoriteFragment();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            case R.id.btn_location:
                fragment = new LocationFragment();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }
}