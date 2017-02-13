package com.appbusters.robinpc.constitutionofindia.ui.all_parts;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
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

public class Part7 extends AppCompatActivity {

    String[] headers, desc;
    RecyclerView recyclerView;
    List<Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part7);

        headers = getResources().getStringArray(R.array.part_6);
        desc = new String[]{getString(R.string.article152), getString(R.string.article153), getString(R.string.article154),
                getString(R.string.article155), getString(R.string.article156), getString(R.string.article157),
                getString(R.string.article158), getString(R.string.article159), getString(R.string.article160),
                getString(R.string.article161), getString(R.string.article162), getString(R.string.article163),
                getString(R.string.article164), getString(R.string.article165), getString(R.string.article166),
                getString(R.string.article167), getString(R.string.article168), getString(R.string.article169),
                getString(R.string.article170), getString(R.string.article171), getString(R.string.article172),
                getString(R.string.article173), getString(R.string.article174), getString(R.string.article175),
                getString(R.string.article176), getString(R.string.article177), getString(R.string.article178),
                getString(R.string.article179), getString(R.string.article180), getString(R.string.article181),
                getString(R.string.article182), getString(R.string.article183), getString(R.string.article184),
                getString(R.string.article185), getString(R.string.article186), getString(R.string.article187),
                getString(R.string.article188), getString(R.string.article189), getString(R.string.article190),
                getString(R.string.article191), getString(R.string.article192), getString(R.string.article193),
                getString(R.string.article194), getString(R.string.article195), getString(R.string.article196),
                getString(R.string.article197), getString(R.string.article198), getString(R.string.article199),
                getString(R.string.article200), getString(R.string.article201), getString(R.string.article202),
                getString(R.string.article203), getString(R.string.article204), getString(R.string.article205),
                getString(R.string.article206), getString(R.string.article207), getString(R.string.article208),
                getString(R.string.article209), getString(R.string.article210), getString(R.string.article211),
                getString(R.string.article212), getString(R.string.article213), getString(R.string.article214),
                getString(R.string.article215), getString(R.string.article216), getString(R.string.article217),
                getString(R.string.article218), getString(R.string.article219), getString(R.string.article220),
                getString(R.string.article221), getString(R.string.article222), getString(R.string.article223),
                getString(R.string.article224),getString(R.string.article224A), getString(R.string.article225), getString(R.string.article226),getString(R.string.article226A),
                getString(R.string.article227), getString(R.string.article228),getString(R.string.article228A), getString(R.string.article229),
                getString(R.string.article230), getString(R.string.article231), getString(R.string.article233),
                getString(R.string.article234), getString(R.string.article235), getString(R.string.article236),
                getString(R.string.article237)};

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
        getMenuInflater().inflate( R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.aboutt:{
                Intent i = new Intent(this, ABOUT.class);
                startActivity(i);
                break;
            }
            case R.id.action_rate:{
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.appbusters.robinpc.constitutionofindia"));
                startActivity(i);
                break;
            }
            case R.id.action_share:{
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, "Hey, Check out this exciting App at: https://play.google.com/store/apps/details?id=com.appbusters.robinpc.constitutionofindia");
                i.setType("text/plain");
                startActivity(i);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
