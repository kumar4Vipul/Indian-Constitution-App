package com.appbusters.robinpc.constitutionofindia.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part1;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part10;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part11;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part12;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part13;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part14;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part15;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part16;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part17;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part18;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part19;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part2;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part20;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part21;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part22;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part23;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part24;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part25;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part26;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part3;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part4;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part5;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part6;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part7;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part8;
import com.appbusters.robinpc.constitutionofindia.ui.all_parts.Part9;
import com.appbusters.robinpc.constitutionofindia.R;

public class parts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void Part1(View view)
    {
        Intent i=new Intent(this,Part1.class);
        startActivity(i);
    }
    public void Part2(View view)
    {
        Intent i=new Intent(this,Part2.class);
        startActivity(i);
    }
    public void Part3(View view)
    {
        Intent i=new Intent(this,Part3.class);
        startActivity(i);
    }
    public void Part4(View view)
    {
        Intent i=new Intent(this,Part4.class);
        startActivity(i);
    }
    public void Part4A(View view)
    {
        Intent i=new Intent(this,Part5.class);
        startActivity(i);
    }
    public void Part5(View view)
    {
        Intent i=new Intent(this,Part6.class);
        startActivity(i);
    }
    public void Part6(View view)
    {
        Intent i=new Intent(this,Part7.class);
        startActivity(i);
    }
    public void Part7(View view)
    {
        Intent i=new Intent(this,Part8.class);
        startActivity(i);
    }
    public void Part8(View view)
    {
        Intent i=new Intent(this,Part9.class);
        startActivity(i);
    }
    public void Part9(View view)
    {
        Intent i=new Intent(this,Part10.class);
        startActivity(i);
    }
    public void Part9A(View view)
    {
        Intent i=new Intent(this,Part11.class);
        startActivity(i);
    }
    public void Part9B(View view)
    {
        Intent i=new Intent(this,Part12.class);
        startActivity(i);
    }
    public void Part10(View view)
    {
        Intent i=new Intent(this,Part13.class);
        startActivity(i);
    }
    public void Part11(View view)
    {
        Intent i=new Intent(this,Part14.class);
        startActivity(i);
    }
    public void Part12(View view)
    {
        Intent i=new Intent(this,Part15.class);
        startActivity(i);
    }
    public void Part13(View view)
    {
        Intent i=new Intent(this,Part16.class);
        startActivity(i);
    }
    public void Part14(View view)
    {
        Intent i=new Intent(this,Part17.class);
        startActivity(i);
    }
    public void Part14A(View view)
    {
        Intent i=new Intent(this,Part18.class);
        startActivity(i);
    }
    public void Part15(View view)
    {
        Intent i=new Intent(this,Part19.class);
        startActivity(i);
    }
    public void Part16(View view)
    {
        Intent i=new Intent(this,Part20.class);
        startActivity(i);
    }
    public void Part17(View view)
    {
        Intent i=new Intent(this,Part21.class);
        startActivity(i);
    }
    public void Part18(View view)
    {
        Intent i=new Intent(this,Part22.class);
        startActivity(i);
    }
    public void Part19(View view)
    {
        Intent i=new Intent(this,Part23.class);
        startActivity(i);
    }
    public void Part20(View view)
    {
        Intent i=new Intent(this,Part24.class);
        startActivity(i);
    }
    public void Part21(View view)
    {
        Intent i=new Intent(this,Part25.class);
        startActivity(i);
    }
    public void Part22(View view)
    {
        Intent i=new Intent(this,Part26.class);
        startActivity(i);
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

        switch (v.getId()){

        }
    }

}
