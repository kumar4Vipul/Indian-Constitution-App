package com.appbusters.robinpc.constitutionofindia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class ScrollingActivity extends AppCompatActivity {

    private Boolean isFabClosed=true;
    private Animation rotate_forward, rotate_backward, fab_open, fab_close;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        rotate_backward= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        rotate_forward= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Snackbar.make(view, "Jai Hind!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    private void animateFab() {
        if(isFabClosed==true){
            fab.startAnimation(rotate_backward);
            isFabClosed=false;
        }
        else{
            fab.startAnimation(rotate_forward);
            isFabClosed=true;
        }
    }

}
