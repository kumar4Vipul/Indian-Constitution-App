package com.appbusters.robinpc.constitutionofindia.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.appbusters.robinpc.constitutionofindia.R;

public class schedules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedules);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClick(View v){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        String[] array={getString(R.string.firstschedule),getString(R.string.secondschedule),
                getString(R.string.thirdschedule),getString(R.string.fourthschedule),
                getString(R.string.fifthschedule),getString(R.string.sixthschedule),
                getString(R.string.seventhschedule),getString(R.string.eighthschedule),
                getString(R.string.ninthschedule),getString(R.string.tenthschedule),
                getString(R.string.eleventhschedule),getString(R.string.twelvethschedule)};

        switch (v.getId()){
            case R.id.s1:
            {
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s2:
            {
                alert.setMessage(array[1]).setTitle("Schedule 2").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s3:
            {
                alert.setMessage(array[2]).setTitle("Schedule 3").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s4:
            {
                alert.setMessage(array[3]).setTitle("Schedule 4").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s5:
            {
                alert.setMessage(array[4]).setTitle("Schedule 5").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s6:
            {
                alert.setMessage(array[5]).setTitle("Schedule 6").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s7:
            {
                alert.setMessage(array[6]).setTitle("Schedule 7").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s8:
            {
                alert.setMessage(array[7]).setTitle("Schedule 8").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s9:
            {
                alert.setMessage(array[8]).setTitle("Schedule 9").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s10:
            {
                alert.setMessage(array[9]).setTitle("Schedule 10").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s11:
            {
                alert.setMessage(array[10]).setTitle("Schedule 11").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s12:
            {
                alert.setMessage(array[11]).setTitle("Schedule 12").setIcon(R.drawable.dialog).create().show();
                break;
            }
        }
    }

}
