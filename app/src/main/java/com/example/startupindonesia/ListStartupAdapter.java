package com.example.startupindonesia;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListStartupAdapter extends  RecyclerView.Adapter<ListStartupAdapter.ListViewHolder> {
    private ArrayList<Startup> listStartup;
    private Context context;

    public ListStartupAdapter(Context jcontext, ArrayList<Startup> jlist){
        listStartup = jlist;
        context = jcontext;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_startup, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Startup startup = listStartup.get(position);

        Glide.with(holder.itemView.getContext())
                .load(startup.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        holder.tvName.setText(startup.getName());
        holder.tvCategory.setText(startup.getCategory());
        holder.tvDescription.setText(startup.getDescription());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailStartupActivity.class);
                intent.putExtra("name", startup.getName());
                intent.putExtra("category", startup.getCategory());
                intent.putExtra("description", startup.getDescription());
                intent.putExtra("image", startup.getPhoto());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listStartup.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvCategory, tvDescription;
        RelativeLayout relativeLayout;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvCategory = itemView.findViewById(R.id.tv_item_category);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            relativeLayout = itemView.findViewById(R.id.relative_layout);
        }
    }
}
