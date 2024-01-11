package com.example.demoinovant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SwatchAdapter extends RecyclerView.Adapter<SwatchAdapter.SwatchViewHolder> {

    private List<String> swatchUrls;

    public SwatchAdapter(List<String> swatchUrls) {
        this.swatchUrls = swatchUrls;
    }

    @NonNull
    @Override
    public SwatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_swatch, parent, false);
        return new SwatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SwatchViewHolder holder, int position) {
        String swatchUrl = swatchUrls.get(position);

        Glide.with(holder.itemView.getContext())
                .load(swatchUrl)
                .placeholder(R.drawable.baseline_favorite_24)
                .into(holder.swatchImageView);
    }

    @Override
    public int getItemCount() {
        return swatchUrls.size();
    }

    static class SwatchViewHolder extends RecyclerView.ViewHolder {
        CircleImageView swatchImageView;

        SwatchViewHolder(View itemView) {
            super(itemView);
            swatchImageView = itemView.findViewById(R.id.swatchImageView);
        }
    }
}
