package com.appbusters.robinpc.constitutionofindia.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.controller.MyDBHelper;
import com.appbusters.robinpc.constitutionofindia.controller.RVA_Saved;
import com.appbusters.robinpc.constitutionofindia.model.Data;
import com.appbusters.robinpc.constitutionofindia.ui.ABOUT;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.List;

public class SavedActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyDBHelper myDBHelper;
    List<Data> data;
    private LinearLayout layout_alternate;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString("save_activity", "opened");

        mFirebaseAnalytics.logEvent("activity_saved", bundle);

        myDBHelper = new MyDBHelper(this);
        layout_alternate = (LinearLayout) findViewById(R.id.layout_alternate);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        data = myDBHelper.getAllItems();

        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);
        RVA_Saved adapter = new RVA_Saved(data, getApplicationContext());

        if(adapter.getItemCount()!=0){
            recyclerView.setVisibility(View.VISIBLE);
            layout_alternate.setVisibility(View.GONE);
            recyclerView.setAdapter(adapter);
        }
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
