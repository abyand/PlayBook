package com.example.abyandafa.playobook.main.fragments.event;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abyandafa.playobook.R;

import java.util.List;

/**
 * Created by Abyan Dafa on 27/10/2018.
 */

public class PlayerDetailAdapter extends RecyclerView.Adapter<PlayerDetailAdapter.ViewHolder> {

    private List<PlayerModel> models;

    public PlayerDetailAdapter(List<PlayerModel> models) {
        this.models = models;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PlayerModel current = models.get(position);
        if(position==0){
            holder.call.setVisibility(View.VISIBLE);
            holder.sms.setVisibility(View.VISIBLE);
        }
        else{
            holder.call.setVisibility(View.INVISIBLE);
            holder.sms.setVisibility(View.INVISIBLE);
        }
        holder.playerName.setText(current.getName());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void initDummy(){
        models.clear();

        models.add(new PlayerModel("Bambang Pamungkas"));
        models.add(new PlayerModel("Arsya Darmawan"));
        models.add(new PlayerModel("Eko Puji Pramono"));
        models.add(new PlayerModel("Wahyu Pujino"));
        models.add(new PlayerModel("Gede Yuga Haqq"));
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView playerName;
        public ImageView call;
        public ImageView sms;
        public ViewHolder(View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);
            call = itemView.findViewById(R.id.call);
            sms = itemView.findViewById(R.id.message);
        }
    }
}
