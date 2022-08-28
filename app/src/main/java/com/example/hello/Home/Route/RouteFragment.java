package com.example.hello.Home.Route;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.hello.Home.FragmentActivity;
import com.example.hello.R;


public class RouteFragment extends Fragment {
    Button btn_voice, btn_text;
    FragmentActivity activity = new FragmentActivity();
    SearchFragment searchFragment = new SearchFragment();
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_route, container, false);
        btn_text = rootView.findViewById(R.id.btn_txt);
        btn_voice = rootView.findViewById(R.id.btn_voice);

        intent = new Intent(getActivity(), FragmentActivity.class);

        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("name", "btn_txt");
                startActivity(intent);
            }
        });
        btn_voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("name", "btn_voice");
                startActivity(intent);
            }
        });
        return rootView;
    }

}