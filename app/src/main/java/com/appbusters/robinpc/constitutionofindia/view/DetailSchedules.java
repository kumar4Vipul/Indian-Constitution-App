package com.appbusters.robinpc.constitutionofindia.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.controller.MyDBHelper;
import com.appbusters.robinpc.constitutionofindia.ui.ABOUT;
import com.appbusters.robinpc.constitutionofindia.utils.SharedPrefs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.HashMap;


public class DetailSchedules extends AppCompatActivity implements TextToSpeech.OnInitListener{

    String schedule_header, schedule_detail;
    TextView header, desc;
    private TextToSpeech tts;
    FloatingActionButton fab;
    private SeekBar seekBar;
    private ImageButton save_button;
    private MyDBHelper myDBHelper;
    private Bundle params;
    private HashMap<String, String> map = new HashMap<>();
    private CircularProgressBar circularProgressBar;
    private FirebaseAnalytics mFirebaseAnalytics;
    private int sizeCount = 0;
    private int ttsCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_schedules);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        params = new Bundle();
        params.putString("detail_screen", "arrived");

        circularProgressBar = findViewById(R.id.circular_progress);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        header = (TextView) findViewById(R.id.header);
        desc = (TextView) findViewById(R.id.desc);
        myDBHelper = new MyDBHelper(this);

        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "uttered");

        seekBar.setMax(80);
        desc.setTextSize(TypedValue.COMPLEX_UNIT_SP, SharedPrefs.getDetailTextSize());
        seekBar.setProgress(SharedPrefs.getDetailTextSize());

        Intent i = getIntent();
        schedule_header = i.getStringExtra("subTitle");
        schedule_detail = i.getStringExtra("Desc");

        save_button = (ImageButton) findViewById(R.id.save_button);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                params.putString("save_button", "clicked");

                if(myDBHelper.checkIfSaved(schedule_header)){

                    save_button.setImageDrawable(getResources().getDrawable(R.drawable.baseline_favorite_white_24));
                    Snackbar.make(view, "Item Saved!", 3000).setAction("View", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(DetailSchedules.this, SavedActivity.class);
                            startActivity(i);
                        }
                    }).show();

                    myDBHelper.insertItem(schedule_header, schedule_detail);

                }
                else {

                    save_button.setImageDrawable(getResources().getDrawable(R.drawable.baseline_favorite_border_white_24));
                    Snackbar.make(view, "Item Removed.!", 3000).setAction("Undo", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            save_button.setImageDrawable(getResources().getDrawable(android.R.drawable.star_big_on));
                            Snackbar.make(view, "Item Saved!", 3000).setAction("View", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i = new Intent(DetailSchedules.this, SavedActivity.class);
                                    startActivity(i);
                                }
                            }).show();

//                            Toast.makeText(DetailSchedules.this, "Item Saved", Toast.LENGTH_SHORT).show();

                            myDBHelper.insertItem(schedule_header, schedule_detail);

                        }
                    }).show();

                    myDBHelper.deleteItem(schedule_header);

                }


            }
        });

        header.setText(schedule_header);
        desc.setText(schedule_detail);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                desc.setTextSize(TypedValue.COMPLEX_UNIT_SP, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPrefs.setDetailTextSize(seekBar.getProgress());
                sizeCount++;
                params.putInt("size_count", sizeCount);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        switch (id){
            case R.id.aboutt:{
                Intent i = new Intent(this, ABOUT.class);
                startActivity(i);
                break;
            }
            case R.id.action_rate:{
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.appbusters.robinpc.constitutionofindia"));
                startActivity(i);
                break;
            }
            case R.id.action_share:{
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, "Hey, Check out this exciting App at: https://play.google.com/store/apps/details?id=com.appbusters.robinpc.constitutionofindia");
                i.setType("text/plain");
                startActivity(i);
                break;
            }
            case R.id.action_share_current:{
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, header.getText() + ": \n " + desc.getText());
                i.setType("text/plain");
                startActivity(i);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.fab:{
                if(tts.isSpeaking()){
                    tts.stop();
                }
                ttsCount++;
                params.putInt("tts_count", ttsCount);
                autoSpeak( header.getText() + ". " + desc.getText());
                break;
            }
        }
    }

    @SuppressWarnings("deprecation")
    private void autoSpeak(String text) {
        if (TextUtils.isEmpty(text) || tts == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_ADD, map);
        } else {
            tts.speak(text, TextToSpeech.QUEUE_ADD, map);
        }
    }

    @Override
    protected void onDestroy() {
        if (tts.isSpeaking()) {
            tts.stop();
        }
        tts.shutdown();

        mFirebaseAnalytics.logEvent("detail_screen_details", params);

        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status != TextToSpeech.SUCCESS) {
            Log.d("InitTextToSpeech", "init text to speech failed; status: " + status);
            tts = null;
        }
        else {
            tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                @Override
                public void onStart(String s) {
                    if(s.equals("uttered")) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                circularProgressBar.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                }

                @Override
                public void onDone(String s) {
                    if(s.equals("uttered")) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                circularProgressBar.setVisibility(View.GONE);
                            }
                        });
                    }
                }

                @Override
                public void onError(String s) {

                }
            });
        }
    }

    @Override
    protected void onStop() {
        if (tts.isSpeaking()) {
            tts.stop();
        }

        mFirebaseAnalytics.logEvent("detail_screen_details", params);

        super.onStop();
    }

    @Override
    protected void onPause() {
        if (tts.isSpeaking()) {
            tts.stop();
        }

        mFirebaseAnalytics.logEvent("detail_screen_details", params);
        super.onPause();
    }

    @Override
    protected void onStart() {

        tts = new TextToSpeech(this, this);

        super.onStart();
    }
}
