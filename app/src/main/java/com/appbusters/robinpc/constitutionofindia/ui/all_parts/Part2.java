package com.appbusters.robinpc.constitutionofindia.ui.all_parts;

import android.content.Intent;
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

public class Part2 extends AppCompatActivity {

    String[] headers, desc;
    List<Data> data;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);

        headers = getResources().getStringArray(R.array.part_2);
        desc = new String[]{getString(R.string.article5),getString(R.string.article6),getString(R.string.article7),
                getString(R.string.article8),getString(R.string.article9),getString(R.string.article10),
                getString(R.string.article11)};
        data = fillWithData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    private List<Data> fillWithData(){
        List<Data> data = new ArrayList<>();
        for(int i = 1; i<=headers.length; i++){
            data.add(new Data(" ", headers[i-1], desc[i-1]));
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

        android.support.v7.app.AlertDialog.Builder alert= new android.support.v7.app.AlertDialog.Builder(this);
        String array[]={getString(R.string.article5),getString(R.string.article6),getString(R.string.article7),
                getString(R.string.article8),getString(R.string.article9),getString(R.string.article10),
                getString(R.string.article11)};

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
    }*/

}
