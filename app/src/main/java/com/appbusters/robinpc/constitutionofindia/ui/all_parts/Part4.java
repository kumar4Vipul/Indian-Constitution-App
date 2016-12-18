package com.appbusters.robinpc.constitutionofindia.ui.all_parts;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.appbusters.robinpc.constitutionofindia.R;

public class Part4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Jai Hind!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View v){

        android.support.v7.app.AlertDialog.Builder alert= new android.support.v7.app.AlertDialog.Builder(this);
        String[] array={getString(R.string.article12),getString(R.string.article13),
                getString(R.string.article14),getString(R.string.article15)};

        switch (v.getId()){
            case R.id.four36:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 36").create().show();
                break;
            }
            case R.id.four37:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 37").create().show();
                break;
            }
            case R.id.four38:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 38").create().show();
                break;
            }
            case R.id.four39:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 39").create().show();
                break;
            }
            case R.id.four39A:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 39A").create().show();
                break;
            }
            case R.id.four40:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 40").create().show();
                break;
            }
            case R.id.four41:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 41").create().show();
                break;
            }
            case R.id.four42:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 42").create().show();
                break;
            }
            case R.id.four43:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 43").create().show();
                break;
            }
            case R.id.four43A:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 43A").create().show();
                break;
            }
            case R.id.four43B:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 43B").create().show();
                break;
            }
            case R.id.four44:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 44").create().show();
                break;
            }
            case R.id.four45:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 45").create().show();
                break;
            }
            case R.id.four46:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 46").create().show();
                break;
            }
            case R.id.four47:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 47").create().show();
                break;
            }
            case R.id.four48:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 48").create().show();
                break;
            }
            case R.id.four48A:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 48A").create().show();
                break;
            }
            case R.id.four49:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 49").create().show();
                break;
            }
            case R.id.four50:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 50").create().show();
                break;
            }
            case R.id.four51:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 51").create().show();
                break;
            }
        }
    }


}
