package com.appbusters.robinpc.constitutionofindia.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.controller.RVA_Subparts;
import com.appbusters.robinpc.constitutionofindia.model.Data;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;

public class AllPartsActivity extends AppCompatActivity {

    private String[] allParts;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RVA_Subparts mRVA_Subparts;
    private List<Data> data;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_parts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString("parts_activity", "opened");

        mFirebaseAnalytics.logEvent("activity_parts", bundle);

        allParts = getResources().getStringArray(R.array.partsList);
        data = fillWithData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRVA_Subparts = new RVA_Subparts(data, getApplicationContext());
        mRecyclerView.setAdapter(mRVA_Subparts);

    }

    private List<Data> fillWithData(){
        List<Data> data = new ArrayList<>();
        for(String s: allParts){
            data.add(new Data(" ", s," "));
        }
        return data;
    }
}
