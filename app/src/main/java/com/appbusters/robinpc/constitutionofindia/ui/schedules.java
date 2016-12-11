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

    // DIALOG FOR Schedule1
    public void Schedule1(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.firstschedule))
                .setTitle("Schedule 1").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR Schedule1
    public void Schedule2(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.secondschedule))
                .setTitle("Schedule 2").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR Schedule1
    public void Schedule3(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.thirdschedule))
                .setTitle("Schedule 3").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR Schedule1
    public void Schedule4(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.fourthschedule))
                .setTitle("Schedule 4").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR Schedule1
    public void Schedule5(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.fifthschedule))
                .setTitle("Schedule 5").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR Schedule1
    public void Schedule6(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.sixthschedule))
                .setTitle("Schedule 6").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR Schedule1
    public void Schedule7(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.seventhschedule))
                .setTitle("Schedule 7").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR Schedule1
    public void Schedule8(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.eighthschedule))
                .setTitle("Schedule 8").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR Schedule1
    public void Schedule9(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.ninthschedule))
                .setTitle("Schedule 9").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR Schedule1
    public void Schedule10(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.tenthschedule))
                .setTitle("Schedule 10").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR Schedule1
    public void Schedule11(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.eleventhschedule))
                .setTitle("Schedule 11").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }
    // DIALOG FOR Schedule1
    public void Schedule12(View view)
    {
        AlertDialog.Builder oneonealert=new AlertDialog.Builder(this);
        oneonealert.setMessage(this.getString(R.string.twelvethschedule))
                .setTitle("Schedule 12").setIcon(R.drawable.dialog).create();
        oneonealert.show();
    }

    public void buttonOnClick(View v){

        Context context=getApplicationContext();
        CharSequence[] text={ "BETA Config. : Favourites","BETA Config. : Search","BETA Config. : Share",
                "BETA Config. : Notes"};

        switch (v.getId())
        {
            case R.id.fabL2:
            {
                Toast.makeText(context,text[0],Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.fabL:
            {
                Toast.makeText(context,text[1],Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.fabR:
            {
                Toast.makeText(context,text[2],Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.fabR2:
            {
                Toast.makeText(context,text[3],Toast.LENGTH_SHORT).show();
                break;
            }
        }
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
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s3:
            {
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s4:
            {
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s5:
            {
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s6:
            {
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s7:
            {
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s8:
            {
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s9:
            {
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s10:
            {
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s11:
            {
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.s12:
            {
                alert.setMessage(array[0]).setTitle("Schedule 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
        }
    }

}
