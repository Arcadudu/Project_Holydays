package ru.arcadudu.project_holydays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    String[] titles;
    int[] images;
    Context context;

    public CategoryAdapter(Context ct, String[] titles, int[] img) {
        this.context = ct;
        this.titles = titles;
        this.images = img;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_iconbar_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.categoryImage.setImageResource(images[position]);
        holder.categoryTitle.setText(titles[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView categoryImage;
        TextView categoryTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.iv_category_icon);
            categoryTitle = itemView.findViewById(R.id.tv_category_title);
        }
    }
}
