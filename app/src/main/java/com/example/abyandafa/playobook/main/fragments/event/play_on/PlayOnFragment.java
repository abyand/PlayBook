package com.example.abyandafa.playobook.main.fragments.event.play_on;


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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayOnFragment extends Fragment {

    private List<PlayOnModel> models;
    private RecyclerView mRecyclerView;
    private PlayOnEventAdapter adapter;

    public PlayOnFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        models = new ArrayList<>();
        adapter = new PlayOnEventAdapter(models, getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
        Log.d("mage its", "onActivityCreated: PlayOnFragment");
        adapter.initDummy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_play_on, container, false);
        mRecyclerView = v.findViewById(R.id.recycler);
        Log.d("mage its", "onCreateView: ");
        return v;
    }

}
