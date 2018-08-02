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
import com.google.firebase.analytics.FirebaseAnalytics;

public class ABOUT extends AppCompatActivity {

    ImageView imageView1, imageView2;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        Glide.with(this)
                .load("https://4.bp.blogspot.com/-Jyz3tF_5YDQ/WQYA6OVDHZI/AAAAAAAAAQg/sKekJ00PnpAGcAFvb4bgEIIEqgxGkgdbQCK4B/s320/17358616_1421007174628701_1935472449784823835_o.jpg")
                .into(imageView2);
        Glide.with(this)
                .load("https://2.bp.blogspot.com/-uj-cptq9ELE/WITQa8VA1xI/AAAAAAAAADg/In0g-bhXoUscy1xR8PTjdueG8PjOTgi3gCLcB/s320/IMG-20161006-WA0009.jpg")
                .into(imageView1);
    }
}
