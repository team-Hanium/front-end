package com.example.hello.Home.Route;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hello.R;

import java.util.List;

public class  PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>{
    private List<SearchResponse.Place> Data;

    PlaceAdapter(List<SearchResponse.Place> list){
        Data = list;
    }

    @NonNull
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  PlaceAdapter.ViewHolder holder, int position) {
        String name = Data.get(position).getPlace_name ();
        String address = Data.get(position).getRoad_address_name();
        String distance = Data.get(position).getDistance();

        holder.name.setText(name);
        holder.address.setText(address);
        holder.distance.setText(distance);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,address, distance;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
             name = itemView.findViewById(R.id.tv_title);
             address = itemView.findViewById(R.id.tv_address);
             distance = itemView.findViewById(R.id.tv_distance);
        }
    }
}
