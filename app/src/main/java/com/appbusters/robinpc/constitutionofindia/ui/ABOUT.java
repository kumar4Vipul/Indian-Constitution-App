package com.appbusters.robinpc.constitutionofindia.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.appbusters.robinpc.constitutionofindia.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ABOUT extends AppCompatActivity {

    ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        Glide.with(this)
                .load("http://4.bp.blogspot.com/-Jyz3tF_5YDQ/WQYA6OVDHZI/AAAAAAAAAQg/sKekJ00PnpAGcAFvb4bgEIIEqgxGkgdbQCK4B/s1600/17358616_1421007174628701_1935472449784823835_o.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .fitCenter()
                .into(imageView1);
        Glide.with(this)
                .load("https://3.bp.blogspot.com/-YjGwQN3cJqQ/WJA0np9XwBI/AAAAAAAAAEo/V5n452vyVVsTTLEh-6jluIhO5mgWhwEOwCLcB/s1600/1485676792605a.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .fitCenter()
                .into(imageView2);
    }
}
