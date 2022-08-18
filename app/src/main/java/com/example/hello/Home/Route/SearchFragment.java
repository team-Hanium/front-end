package com.example.hello.Home.Route;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import com.example.hello.R;

import java.util.Optional;


public class SearchFragment extends Fragment {
    EditText et;
    WebView wv;
    Button btn;
    String p, q_long, q_lat; //p 검색어, q_long 현재 경도, q_lat 현재 위도

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, null);

        et = view.findViewById(R.id.et);
        wv = view.findViewById(R.id.wv);
        btn = view.findViewById(R.id.btn);

        LocationManager locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = et.getText().toString();

                @SuppressLint("MissingPermission")
                Location loc_current = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
                q_long = String.valueOf(loc_current.getLongitude());
                q_lat = String.valueOf(loc_current.getLatitude());

                //웹뷰 셋팅
                wv.setWebViewClient(new WebViewClient());
                WebSettings settings = wv.getSettings();
                settings.setJavaScriptEnabled(true);
                Uri.Builder builder = new Uri.Builder();
                builder.scheme("kakaomap")
                        .appendPath("search")
                        .appendQueryParameter("p", p)
                        .appendQueryParameter("q",q_lat+ ","+ q_long);

                String url = builder.build().toString();
                wv.loadUrl(url);


            }

        });

        return view;

    }



}