package com.example.abyandafa.playobook.main.fragments.event.available;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abyandafa.playobook.R;
import com.example.abyandafa.playobook.main.fragments.event.play_on.PlayOnModel;

import java.util.ArrayList;
import java.util.List;

public class AvailableEventFragment extends Fragment {

    private List<PlayOnModel> models;
    private RecyclerView mRecyclerView;
    private AvailableEventAdapter adapter;

    public AvailableEventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        models = new ArrayList<>();
        adapter = new AvailableEventAdapter(models, getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
        Log.d("mage its", "onActivityCreated: PlayOnFragment");
        adapter.initDummy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_available_event, container, false);
        mRecyclerView = v.findViewById(R.id.recycler);
        return v;
    }


}
