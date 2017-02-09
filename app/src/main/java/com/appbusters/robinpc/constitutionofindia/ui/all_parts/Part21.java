package com.appbusters.robinpc.constitutionofindia.ui.all_parts;

import android.app.AlertDialog;
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

public class Part21 extends AppCompatActivity {

    String[] headers, desc;
    RecyclerView recyclerView;
    List<Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part21);

        headers = getResources().getStringArray(R.array.part_17);
        desc = new String[]{
                getString(R.string.article343),getString(R.string.article344),getString(R.string.article345),
                getString(R.string.article346),getString(R.string.article347),getString(R.string.article348),
                getString(R.string.article349),getString(R.string.article350),getString(R.string.article350a),
                getString(R.string.article350b),getString(R.string.article351)};

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



    public void article343(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article343)).create();
        builder.show();
    }
    public void article344(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article344)).create();
        builder.show();
    }
    public void article345(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article345)).create();
        builder.show();
    }
    public void article346(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article346)).create();
        builder.show();
    }
    public void article347(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article347)).create();
        builder.show();
    }
    public void article348(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article348)).create();
        builder.show();
    }
    public void article349(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article349)).create();
        builder.show();
    }
    public void article350(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article350)).create();
        builder.show();
    }
    public void article350A(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article350a)).create();
        builder.show();
    }
    public void article350B(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article350b)).create();
        builder.show();
    }
    public void article351(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article351)).create();
        builder.show();
    }
}
