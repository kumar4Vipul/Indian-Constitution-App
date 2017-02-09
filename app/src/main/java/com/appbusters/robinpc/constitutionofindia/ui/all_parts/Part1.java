package com.appbusters.robinpc.constitutionofindia.ui.all_parts;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.controller.Recycler_View_Adapter;
import com.appbusters.robinpc.constitutionofindia.model.Data;
import com.appbusters.robinpc.constitutionofindia.ui.ABOUT;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends AppCompatActivity {

    List<Data> data;
    String[] headers, desc;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);


        headers = getResources().getStringArray(R.array.part_1);
        desc = new String[]{getString(R.string.article1),getString(R.string.article2),getString(R.string.article2A),
                getString(R.string.article3),getString(R.string.article4)};

        data = fillWithData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplicationContext());
        recyclerView.setAdapter(adapter);

    }

    private List<Data> fillWithData(){
        List<Data> data = new ArrayList<>();

        for(int i = 1; i <= desc.length; i++){
            data.add(new Data(" ", headers[i-1] , desc[i-1]));
        }

        return data;
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id ==  R.id.aboutt)
        {
            Intent i=new Intent(this,ABOUT.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
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
    }*/
}
