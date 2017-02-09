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

public class Part19 extends AppCompatActivity {

    String[] headers, desc;
    RecyclerView recyclerView;
    List<Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part19);

        headers = getResources().getStringArray(R.array.part_15);
        desc = new String[]{
                getString(R.string.article324),getString(R.string.article325),getString(R.string.article326),
                getString(R.string.article327),getString(R.string.article328),getString(R.string.article329),
                getString(R.string.article329a)};

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



    public void article324(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article324)).create();
        builder.show();
    }
    public void article325(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article325)).create();
        builder.show();
    }
    public void article326(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article326)).create();
        builder.show();
    }
    public void article327(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article327)).create();
        builder.show();
    }
    public void article328(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article328)).create();
        builder.show();
    }
    public void article329(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article329)).create();
        builder.show();
    }
    public void article329A(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article329a)).create();
        builder.show();
    }
}
