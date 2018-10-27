package com.example.abyandafa.playobook.main.fragments.event.play_on.detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abyandafa.playobook.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Abyan Dafa on 27/10/2018.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.VIewHolder>  {

    private List<CommentModel> models;

    public CommentAdapter(List<CommentModel> models) {
        this.models = models;
    }

    @Override
    public VIewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_item, parent, false);
        return new VIewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VIewHolder holder, int position) {
        CommentModel current = models.get(position);
        holder.chatItem.setText(current.getText());
        holder.username.setText(current.getUser());
        holder.sendTime.setText(current.getTime());
    }

    public void addItem(String username, String text){
        Date currentDate =  Calendar.getInstance().getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
        String time = sdf.format(currentDate);
        models.add(new CommentModel(username, text, time));
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class VIewHolder extends RecyclerView.ViewHolder {
        public TextView sendTime;
        public TextView username;
        public TextView chatItem;
        public VIewHolder(View itemView) {
            super(itemView);
            sendTime = itemView.findViewById(R.id.send_time);
            username = itemView.findViewById(R.id.username);
            chatItem = itemView.findViewById(R.id.chat_item);
        }
    }
}
