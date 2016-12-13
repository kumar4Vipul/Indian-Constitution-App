package com.appbusters.robinpc.constitutionofindia.ui.all_parts;

import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.appbusters.robinpc.constitutionofindia.R;

public class Part1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Jai Hind!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View v){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        String array[]={getString(R.string.article1),getString(R.string.article2),getString(R.string.article2A),
                getString(R.string.article3),getString(R.string.article4)};

        switch (v.getId()){
            case R.id.one1:
            {
                alert.setMessage(array[0]).setTitle("Article 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.one2:
            {
                alert.setMessage(array[1]).setTitle("Article 2").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.one2A:
            {
                alert.setMessage(array[2]).setTitle("Article 2A").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.one3:
            {
                alert.setMessage(array[3]).setTitle("Article 3").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.one4:
            {
                alert.setMessage(array[4]).setTitle("Article 4").setIcon(R.drawable.dialog).create().show();
                break;
            }
        }
    }
}
