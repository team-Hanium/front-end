package com.example.hello.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.hello.Home.Arround.ArroundFragment;
import com.example.hello.Home.Favorites.FavoriteFragment;
import com.example.hello.Home.LocationShare.LocationFragment;
import com.example.hello.Home.Route.RouteFragment;
import com.example.hello.Home.Route.SearchFragment;
import com.example.hello.R;

public class FragmentActivity extends AppCompatActivity {
    private RouteFragment routefragment;
    private ArroundFragment arroundfragment;
    private LocationFragment locationFragment;
    private FavoriteFragment favoriteFragment;
    private SearchFragment searchFragment;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        routefragment = new RouteFragment();
        arroundfragment = new ArroundFragment();
        locationFragment = new LocationFragment();
        favoriteFragment = new FavoriteFragment();
        searchFragment = new SearchFragment();

       intent = getIntent();
       String btnName = intent.getStringExtra("name");
       FragmentManager fragmentManager = getSupportFragmentManager();

       switch (btnName){
           case "arround":
               fragmentManager.beginTransaction().replace(R.id.layoutContainer, arroundfragment).commit();
               break;
           case "route":
               fragmentManager.beginTransaction().replace(R.id.layoutContainer, routefragment).commit();
               break;
           case "favorite":
               fragmentManager.beginTransaction().replace(R.id.layoutContainer, favoriteFragment).commit();
               break;
           case "location":
               fragmentManager.beginTransaction().replace(R.id.layoutContainer, locationFragment).commit();
               break;
           case "btn_txt":
               fragmentManager.beginTransaction().replace(R.id.layoutContainer, searchFragment).commit();
       }
    }
}