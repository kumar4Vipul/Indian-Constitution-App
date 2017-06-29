package com.appbusters.robinpc.constitutionofindia.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;

public class amendments extends AppCompatActivity {

    List<Data> data;
    String[] all_amendments;
    RecyclerView recyclerView;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amendments);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        all_amendments = new String[]{getString(R.string.firstamendment),getString(R.string.secondamendment),getString(R.string.thirdamendment),
                getString(R.string.fourthamendment),getString(R.string.fifthamendment),getString(R.string.sixthamendment),
                getString(R.string.seventhamendment),getString(R.string.eighthamendment),getString(R.string.ninthamendment),
                getString(R.string.tenthamendment),getString(R.string.eleventhamendment),getString(R.string.twelfthamendment),
                getString(R.string.thirteenthamendment),getString(R.string.fourteenthamendment),getString(R.string.fifteenthamendment),
                getString(R.string.sixteenthamendment),getString(R.string.seventeenthamendment),getString(R.string.eighteenthamendment),
                getString(R.string.nineteenthamendment),getString(R.string.twentiethamendment),getString(R.string.twentyfirstamendment),
                getString(R.string.twentysecondamendment),getString(R.string.twentythirdamendment),getString(R.string.twentyfourthamendment),
                getString(R.string.twentyfifthamendment),getString(R.string.twentysixthamendment),getString(R.string.twentyseventhamendment),
                getString(R.string.twentyeighthamendment),getString(R.string.twentyninethamendment),getString(R.string.thirteethamendment),
                getString(R.string.thirtyfirstamendment),getString(R.string.thirtysecondamendment),getString(R.string.thirtythirdamendment),
                getString(R.string.thirtyfourthamendment),getString(R.string.thirtyfifthamendment),getString(R.string.thirtysixthamendment),
                getString(R.string.thirtyseventhamendment),getString(R.string.thirtyeighthamendment),getString(R.string.thirtyninthamendment),
                getString(R.string.fortiethamendment),getString(R.string.fourtyfirstamendment),getString(R.string.fourtysecondamendment),
                getString(R.string.fourtythirdamendment),getString(R.string.fortyfourthamendment),getString(R.string.fortyfifthamendment),
                getString(R.string.fortysixthamendment),getString(R.string.fortyseventhamendment),getString(R.string.fortyeighthamendment),
                getString(R.string.fourtyninthamendment),getString(R.string.fiftiethamendment),getString(R.string.fiftyfirstamendment),
                getString(R.string.fiftysecondamendment),getString(R.string.fiftythirdamendment),getString(R.string.fiftyfourthamendment),
                getString(R.string.fiftyfifthamendment),getString(R.string.fiftysixthamendment),getString(R.string.fiftyseventhamendment),
                getString(R.string.fiftyeighthamendment),getString(R.string.fiftyninthamendment),getString(R.string.sixtiethamendment),
                getString(R.string.sixtyfirstamendment),getString(R.string.sixtysecondamendment),getString(R.string.sixtythirdamendment),
                getString(R.string.sixtyfourthamendment),getString(R.string.sixtyfifthamendment),getString(R.string.sixtysixthamendment),
                getString(R.string.sixtyseventhamendment),getString(R.string.sixtyeighthamendment),getString(R.string.sixtyninthamendment),
                getString(R.string.seventiethamendment),getString(R.string.seventyfirstamendment),getString(R.string.seventysecondamendment),
                getString(R.string.seventythirdamendment),getString(R.string.seventyfourthamendment),getString(R.string.seventyfifthamendment),
                getString(R.string.seventysixthamendment),getString(R.string.seventyseventhamendment),getString(R.string.seventyeighthamendment),
                getString(R.string.seventyninthamendment),getString(R.string.eightiethamendment),getString(R.string.eightyfirstamendment),
                getString(R.string.eightysecondamendment),getString(R.string.eightythirdamendment),getString(R.string.eightyfourthamendment),
                getString(R.string.eightyfifthamendment),getString(R.string.eightysixthamendment),getString(R.string.eightyseventhamendment),
                getString(R.string.eightyeighthamendment),getString(R.string.eightyninthamendment),getString(R.string.ninetiethamendment),
                getString(R.string.ninetyonethamendment),getString(R.string.ninetysecondamendment),getString(R.string.ninetythirdamendment),
                getString(R.string.ninetyfourthamendment),getString(R.string.ninetyfifthamendment),getString(R.string.ninetysixthamendment),
                getString(R.string.ninetyseventhamendment),getString(R.string.ninetyeighthamendment),getString(R.string.ninetyninthamendment),
                getString(R.string.hundredthamendment)};

        data = fillWithData();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplicationContext());
        recyclerView.setAdapter(adapter);

    }


    private List<Data> fillWithData(){
        List<Data> data = new ArrayList<>();

        for(int i = 1; i <= 100; i++){
            data.add(new Data(" ", "Amendment " + i , all_amendments[i-1]));
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

