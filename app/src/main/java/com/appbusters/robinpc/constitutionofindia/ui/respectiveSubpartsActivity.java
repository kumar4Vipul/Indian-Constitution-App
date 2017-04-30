package com.appbusters.robinpc.constitutionofindia.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.appbusters.robinpc.constitutionofindia.R;

public class respectiveSubpartsActivity extends AppCompatActivity {

    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respective_subparts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView = (TextView) findViewById(R.id.textView);
        category = getIntent().getStringExtra("subTitle");
        textView.setText(category);
    }
}
