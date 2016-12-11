package com.appbusters.robinpc.constitutionofindia.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.appbusters.robinpc.constitutionofindia.R;

public class ScrollingActivity extends AppCompatActivity {

    private Boolean FabClosed=true;
    private Animation rotate_forward, rotate_backward, fab_open, fab_close;
    private FloatingActionButton fab, fabL, fabR, fabL2, fabR2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab= (FloatingActionButton) findViewById(R.id.fab);
        fabL= (FloatingActionButton) findViewById(R.id.fabL);
        fabR= (FloatingActionButton) findViewById(R.id.fabR);
        fabL2= (FloatingActionButton) findViewById(R.id.fabL2);
        fabR2= (FloatingActionButton) findViewById(R.id.fabR2);

        fab_open= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fab_close= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_backward= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        rotate_forward= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        Animation alpha_initial= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_initial);
        Animation fab_close_initial= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close_initial);

        fab.setAnimation(alpha_initial);
        fabL.setAnimation(fab_close_initial);
        fabR.setAnimation(fab_close_initial);
        fabL2.setAnimation(fab_close_initial);
        fabR2.setAnimation(fab_close_initial);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatefab();
            }
        });

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




    public void preamble(View view)
    {
        Intent i=new Intent(this,preamble.class);
        startActivity(i);
    }

    public void amendments(View view)
    {
        Intent i=new Intent(this,amendments.class);
        startActivity(i);
    }

    public void parts(View view)
    {
        Intent i=new Intent(this,parts.class);
        startActivity(i);
    }
    public void schedules(View view)
    {
        Intent i=new Intent(this,schedules.class);
        startActivity(i);
    }

    private void animatefab() {

        if(FabClosed){
            fab.startAnimation(rotate_forward);
            fabL.startAnimation(fab_open);
            fabR.startAnimation(fab_open);
            fabL2.setAnimation(fab_open);
            fabR2.setAnimation(fab_open);
            FabClosed=false;
        }
        else{
            fab.startAnimation(rotate_backward);
            fabL.startAnimation(fab_close);
            fabR.startAnimation(fab_close);
            fabL2.setAnimation(fab_close);
            fabR2.setAnimation(fab_close);
            FabClosed=true;
        }
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

}
