package com.appbusters.robinpc.constitutionofindia.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.appbusters.robinpc.constitutionofindia.R;

public class DetailSchedules extends AppCompatActivity {

    String schedule_header, schedule_detail;
    TextView header, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_schedules);

        header = (TextView) findViewById(R.id.header);
        desc = (TextView) findViewById(R.id.desc);

        Intent i = getIntent();
        schedule_header = i.getStringExtra("subTitle");
        schedule_detail = i.getStringExtra("Desc");

        header.setText(schedule_header);
        desc.setText(schedule_detail);
    }
}
