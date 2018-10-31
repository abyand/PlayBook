package com.example.abyandafa.playobook.main.create;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abyandafa.playobook.R;

import java.util.ArrayList;
import java.util.List;

public class CreateEventActivity extends AppCompatActivity {

    private List<String> list;

    TextView location;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        setAllRegion();
        location  = findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.show();
            }
        });
        Button create= findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void setAllRegion(){
        list = new ArrayList<>();
        list.add("All Location");
        list.add("Asemrowo");
        list.add("Benowo");
        list.add("Bubutan");
        list.add("Bulak");
        list.add("Dukuh Pakis");
        list.add("Gayungan");
        list.add("Genteng");
        list.add("Gubeng");
        list.add("Gunung Anyar");
        list.add("Kenjeran");
        list.add("Mulyorejo");
        list.add("Rungkut");
        list.add("Sawahan");
        list.add("Sukolilo");
        list.add("Tambaksari");
        list.add("Tandes");
        list.add("Tegalsari");
        list.add("Wonocolo");
        list.add("Wonokromo");

        final CharSequence[] options = list.toArray(new CharSequence[list.size()]);


        builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setSingleChoiceItems(options, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                location.setText(options[which]);
            }
        });



    }
}
