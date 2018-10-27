package com.example.abyandafa.playobook.main.fragments.event.play_on.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.abyandafa.playobook.R;
import com.example.abyandafa.playobook.main.fragments.event.PlayerDetailAdapter;
import com.example.abyandafa.playobook.main.fragments.event.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public class PlayOnDetailActivity extends AppCompatActivity {

    private List<PlayerModel> models;
    private RecyclerView mRecyclerView;
    private PlayerDetailAdapter adapter;
    private Toolbar toolbar;

    private RecyclerView cRecyclerView;
    private List<CommentModel> commentModels;
    private CommentAdapter cAdapter;
    private EditText comment;
    private ImageView sendComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_on_detail);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView = findViewById(R.id.recycler);
        models = new ArrayList<>();
        adapter = new PlayerDetailAdapter(models);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        Log.d("mage its", "onActivityCreated: PlayOnFragment");
        adapter.initDummy();

        cRecyclerView = findViewById(R.id.chat);
        comment = findViewById(R.id.chat_item);
        sendComment = findViewById(R.id.send_button);
        commentModels = new ArrayList<>();
        cAdapter = new CommentAdapter(commentModels);
        cRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cRecyclerView.setAdapter(cAdapter);

        sendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });


    }

    private void send() {
        if(comment.getText().toString().isEmpty())
            return;
        cAdapter.addItem("Wahyu Pujino", comment.getText().toString());
        comment.setText("");
    }
}
