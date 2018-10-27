package com.example.abyandafa.playobook.main.fragments.event.available.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.abyandafa.playobook.R;
import com.example.abyandafa.playobook.main.fragments.event.PlayerDetailAdapter;
import com.example.abyandafa.playobook.main.fragments.event.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public class AvailableDetailActivity extends AppCompatActivity {

    private List<PlayerModel> models;
    private RecyclerView mRecyclerView;
    private PlayerDetailAdapter adapter;
    private Toolbar toolbar;
    private Button join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_detail);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView = findViewById(R.id.recycler);
        models = new ArrayList<>();
        adapter = new PlayerDetailAdapter(models);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        Log.d("mage its", "onActivityCreated: PlayOnFragment");
        adapter.initDummy();
        join = findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AvailableDetailActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
