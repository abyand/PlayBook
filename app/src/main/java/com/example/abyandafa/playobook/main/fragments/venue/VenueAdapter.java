package com.example.abyandafa.playobook.main.fragments.venue;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abyandafa.playobook.R;

import java.util.List;

/**
 * Created by Abyan Dafa on 30/10/2018.
 */

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.PlayOnViewHolder> {

    private List<VenueModel> models;

    public VenueAdapter(List<VenueModel> models) {
        this.models = models;
    }

    @Override
    public VenueAdapter.PlayOnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.venue_item, parent, false);

        return new PlayOnViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VenueAdapter.PlayOnViewHolder holder, int position) {
        VenueModel current = models.get(position);
        holder.venueFee.setText(current.getVenueFee());
        holder.venueAddress.setText(current.getVenueAddress());
        holder.venueName.setText(current.getVenueName());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void initDummy(){
        models.clear();

        models.add(new VenueModel("FIVA FUTSAL", "BUMI MARINA EMAS", "RP. 150.000 / jam"));
        notifyDataSetChanged();
    }

    public class PlayOnViewHolder extends RecyclerView.ViewHolder {
        public TextView venueName, venueAddress, venueFee;
        public PlayOnViewHolder(View itemView) {
            super(itemView);
            venueName = itemView.findViewById(R.id.venue_name);
            venueAddress = itemView.findViewById(R.id.venue_address);
            venueFee = itemView.findViewById(R.id.venue_fee);
        }
    }
}
