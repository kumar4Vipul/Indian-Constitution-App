package com.appbusters.robinpc.constitutionofindia.ui.all_parts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.appbusters.robinpc.constitutionofindia.R;

public class Part2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Jai Hind!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View v){

        android.support.v7.app.AlertDialog.Builder alert= new android.support.v7.app.AlertDialog.Builder(this);
        String array[]={getString(R.string.article5),getString(R.string.article6),getString(R.string.article7),
                getString(R.string.article8),getString(R.string.article9),getString(R.string.article10),getString(R.string.article11)};

        switch (v.getId()){
            case R.id.two5:
            {
                alert.setMessage(array[0]).setTitle("Article 5").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.two6:
            {
                alert.setMessage(array[1]).setTitle("Article 6").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.two7:
            {
                alert.setMessage(array[2]).setTitle("Article 7").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.two8:
            {
                alert.setMessage(array[3]).setTitle("Article 8").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.two9:
            {
                alert.setMessage(array[4]).setTitle("Article 9").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.two10:
            {
                alert.setMessage(array[5]).setTitle("Article 10").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.two11:
            {
                alert.setMessage(array[6]).setTitle("Article 11").setIcon(R.drawable.dialog).create().show();
                break;
            }
        }
    }

}
