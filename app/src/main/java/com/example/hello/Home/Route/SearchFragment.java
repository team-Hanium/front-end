package com.example.hello.Home.Route;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.hello.Network.Api;
import com.example.hello.Network.ApiInterface;
import com.example.hello.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {
    EditText et;

    Button btn;
    String query, lon, lat; //검색어, 현재 경도,현재 위도
    static final Integer size = 5;
    static final String BASE_URL = "https://dapi.kakao.com/";
    static final String key = "KakaoAK 541ad89596281655c03133f110901fe6";

    //권한체크 변수
    static final int PERMISSION_REQUEST_READ_LOCATION = 0x00000001;
    private String[] PERMISSION = { Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, null);

        et = view.findViewById(R.id.et);
        btn = view.findViewById(R.id.btn);

        if (ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)){

        }

        //프래그먼트에서 권한체크  https://ddolcat.tistory.com/449  //처음 권한, 거부 후 https://copycoding.tistory.com/357
        int i = ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        if(i ==-1){
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_READ_LOCATION);
        }
        

        LocationManager locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query = et.getText().toString();

                @SuppressLint("MissingPermission")
                Location loc_current = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
                lon = String.valueOf(loc_current.getLongitude());
                lat = String.valueOf(loc_current.getLatitude());

                Api.changeApiBaseUrl(BASE_URL);
                ApiInterface apiInterface = Api.createService(ApiInterface.class);
               apiInterface.getPlaces(key, lat, lon, query, size).enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                        System.out.println(response.body());
                    }

                    @Override
                    public void onFailure(Call<SearchResponse> call, Throwable t) {

                    }
                });
            }

        });

        return view;

    }



}