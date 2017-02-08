package com.appbusters.robinpc.constitutionofindia.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

    public void onClick(View v){

        switch (v.getId())
        {
            case R.id.p1:
            {
                Intent i= new Intent(this, Part1.class);
                startActivity(i);
                break;
            }
            case R.id.p2:
            {
                Intent i= new Intent(this, Part2.class);
                startActivity(i);
                break;
            }
            case R.id.p3:
            {
                Intent i= new Intent(this, Part3.class);
                startActivity(i);
                break;
            }
            case R.id.p4:
            {
                Intent i= new Intent(this, Part4.class);
                startActivity(i);
                break;
            }
            case R.id.p4A:
            {
                Intent i= new Intent(this, Part5.class);
                startActivity(i);
                break;
            }
            case R.id.p5:
            {
                Intent i= new Intent(this, Part6.class);
                startActivity(i);
                break;
            }
            case R.id.p6:
            {
                Intent i= new Intent(this, Part7.class);
                startActivity(i);
                break;
            }
            case R.id.p7:
            {
                Intent i= new Intent(this, Part8.class);
                startActivity(i);
                break;
            }
            case R.id.p8:
            {
                Intent i= new Intent(this, Part9.class);
                startActivity(i);
                break;
            }
            case R.id.p9:
            {
                Intent i= new Intent(this, Part10.class);
                startActivity(i);
                break;
            }
            case R.id.p9A:
            {
                Intent i= new Intent(this, Part11.class);
                startActivity(i);
                break;
            }
            case R.id.p9B:
            {
                Intent i= new Intent(this, Part12.class);
                startActivity(i);
                break;
            }
            case R.id.p10:
            {
                Intent i= new Intent(this, Part13.class);
                startActivity(i);
                break;
            }
            case R.id.p11:
            {
                Intent i= new Intent(this, Part14.class);
                startActivity(i);
                break;
            }
            case R.id.p12:
            {
                Intent i= new Intent(this, Part15.class);
                startActivity(i);
                break;
            }
            case R.id.p13:
            {
                Intent i= new Intent(this, Part16.class);
                startActivity(i);
                break;
            }
            case R.id.p14:
            {
                Intent i= new Intent(this, Part17.class);
                startActivity(i);
                break;
            }
            case R.id.p14A:
            {
                Intent i= new Intent(this, Part18.class);
                startActivity(i);
                break;
            }
            case R.id.p15:
            {
                Intent i= new Intent(this, Part19.class);
                startActivity(i);
                break;
            }
            case R.id.p16:
            {
                Intent i= new Intent(this, Part20.class);
                startActivity(i);
                break;
            }
            case R.id.p17:
            {
                Intent i= new Intent(this, Part21.class);
                startActivity(i);
                break;
            }
            case R.id.p18:
            {
                Intent i= new Intent(this, Part22.class);
                startActivity(i);
                break;
            }
            case R.id.p19:
            {
                Intent i= new Intent(this, Part23.class);
                startActivity(i);
                break;
            }
            case R.id.p20:
            {
                Intent i= new Intent(this, Part24.class);
                startActivity(i);
                break;
            }
            case R.id.p21:
            {
                Intent i= new Intent(this, Part25.class);
                startActivity(i);
                break;
            }
            case R.id.p22:
            {
                Intent i= new Intent(this, Part26.class);
                startActivity(i);
                break;
            }
        }
    }

}
