package ru.arcadudu.project_holydays.home_activity.utils;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.arcadudu.project_holydays.R;

public class FeedItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<FeedItem> feedItemList;

    public FeedItemAdapter(List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerView.ViewHolder
                (LayoutInflater.from(parent.getContext()).inflate
                        (R.layout.my_new_feed, parent, false)) {
        };
    }

//    @Override
//    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
//    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageView image = holder.itemView.findViewById(R.id.iv_feed_image);
        image.setImageResource(feedItemList.get(position).getImage());
        TextView sale = holder.itemView.findViewById(R.id.tv_feed_sale);
        sale.setText(feedItemList.get(position).getSale());
        TextView oldPrice = holder.itemView.findViewById(R.id.tv_old_price);
        oldPrice.setText(feedItemList.get(position).getOldPrice());
        oldPrice.setPaintFlags(oldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        TextView newPrice = holder.itemView.findViewById(R.id.tv_new_price);
        newPrice.setText(feedItemList.get(position).getNewPrice());
        TextView description = holder.itemView.findViewById(R.id.tv_feed_item_description);
        description.setText(feedItemList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return feedItemList.size();
    }
}
// переделать под кастомный холдер