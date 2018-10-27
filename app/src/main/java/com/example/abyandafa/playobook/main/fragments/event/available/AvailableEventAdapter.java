package com.example.abyandafa.playobook.main.fragments.event.available;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abyandafa.playobook.R;
import com.example.abyandafa.playobook.main.fragments.event.available.detail.AvailableDetailActivity;
import com.example.abyandafa.playobook.main.fragments.event.play_on.detail.PlayOnDetailActivity;
import com.example.abyandafa.playobook.main.fragments.event.play_on.PlayOnModel;

import java.util.List;

/**
 * Created by Abyan Dafa on 27/10/2018.
 */

public class AvailableEventAdapter extends RecyclerView.Adapter<AvailableEventAdapter.PlayOnViewHolder>  {

    private List<PlayOnModel> models;
    private Context context;

    public AvailableEventAdapter(List<PlayOnModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public AvailableEventAdapter.PlayOnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.available_item, parent, false);
        return new PlayOnViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AvailableEventAdapter.PlayOnViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, AvailableDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class PlayOnViewHolder extends RecyclerView.ViewHolder {
        public PlayOnViewHolder(View itemView) {
            super(itemView);
        }
    }
    void initDummy(){
        models.clear();
        for(int i=0; i<10; i++){
            models.add(new PlayOnModel("sd"));
        }
        notifyDataSetChanged();
    }
}
