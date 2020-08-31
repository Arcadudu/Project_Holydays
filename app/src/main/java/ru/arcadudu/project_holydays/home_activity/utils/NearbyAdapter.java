package ru.arcadudu.project_holydays.home_activity.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import ru.arcadudu.project_holydays.R;

public class NearbyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Nearby> nearbyList;

    public NearbyAdapter(List<Nearby> nearbyList) {
        this.nearbyList = nearbyList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerView.ViewHolder
                (LayoutInflater.from(parent.getContext()).inflate
                        (R.layout.my_viewholder_nearby, parent, false)) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageView nearbyImage = holder.itemView.findViewById(R.id.nearby_image);
        nearbyImage.setImageResource(nearbyList.get(position).getImage());
        TextView nearbyDescription = holder.itemView.findViewById(R.id.nearby_description);
        nearbyDescription.setText(nearbyList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return nearbyList.size();
    }
}
