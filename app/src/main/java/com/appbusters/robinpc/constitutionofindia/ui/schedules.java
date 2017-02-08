package com.appbusters.robinpc.constitutionofindia.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.controller.Recycler_View_Adapter;
import com.appbusters.robinpc.constitutionofindia.model.Data;

import java.util.ArrayList;
import java.util.List;

public class schedules extends AppCompatActivity {

    private String[] all_schedules;
    RecyclerView recyclerView;
    List<Data> data;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedules);

        context = getApplicationContext();
        all_schedules = getResources().getStringArray(R.array.all_schedules);

        data = fillWithData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplicationContext());
        recyclerView.setAdapter(adapter);

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

    private List<Data> fillWithData(){
        List<Data> data = new ArrayList<>();

        for(int i = 1; i <= 12; i++){
            data.add(new Data(" ", "Schedule " + i , all_schedules[i-1]));
        }

        return data;
    }

    /*
    public void onClick(View v){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);

        switch (v.getId()){
            case R.id.s1:
            {
                alert.setMessage(all_schedules[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s2:
            {
                alert.setMessage(all_schedules[1]).setTitle("Schedule 2").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s3:
            {
                alert.setMessage(all_schedules[2]).setTitle("Schedule 3").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s4:
            {
                alert.setMessage(all_schedules[3]).setTitle("Schedule 4").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s5:
            {
                alert.setMessage(all_schedules[4]).setTitle("Schedule 5").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s6:
            {
                alert.setMessage(all_schedules[5]).setTitle("Schedule 6").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s7:
            {
                alert.setMessage(all_schedules[6]).setTitle("Schedule 7").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s8:
            {
                alert.setMessage(all_schedules[7]).setTitle("Schedule 8").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s9:
            {
                alert.setMessage(all_schedules[8]).setTitle("Schedule 9").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s10:
            {
                alert.setMessage(all_schedules[9]).setTitle("Schedule 10").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s11:
            {
                alert.setMessage(all_schedules[10]).setTitle("Schedule 11").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s12:
            {
                alert.setMessage(all_schedules[11]).setTitle("Schedule 12").setIcon(R.drawable.dialog).create().show();
                break;
            }
        }
    }
    */

}
