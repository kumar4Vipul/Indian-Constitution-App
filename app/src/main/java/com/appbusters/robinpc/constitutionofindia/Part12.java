package com.appbusters.robinpc.constitutionofindia;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Part12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part12);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }




    public void article243ZH(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZH)).create(); builder.show();
    }
    public void article243ZI(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZI)).create(); builder.show();
    }
    public void article243ZJ(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZJ)).create(); builder.show();
    }
    public void article243ZK(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZK)).create(); builder.show();
    }
    public void article243ZL(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZL)).create(); builder.show();
    }
    public void article243ZM(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZM)).create(); builder.show();
    }
    public void article243ZN(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZN)).create(); builder.show();
    }
    public void article243ZO(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZO)).create(); builder.show();
    }
    public void article243ZP(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZP)).create(); builder.show();
    }
    public void article243ZQ(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZQ)).create(); builder.show();
    }
    public void article243ZR(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZR)).create(); builder.show();
    }
    public void article243ZS(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZS)).create(); builder.show();
    }
    public void article243ZT(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this); builder.setMessage(this.getString(R.string.article243ZT)).create(); builder.show();
    }


}
