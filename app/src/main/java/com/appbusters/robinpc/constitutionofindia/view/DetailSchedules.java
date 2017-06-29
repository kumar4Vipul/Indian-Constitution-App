package com.appbusters.robinpc.constitutionofindia.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import com.github.jorgecastilloprz.FABProgressCircle;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.HashMap;


public class DetailSchedules extends AppCompatActivity implements TextToSpeech.OnInitListener{

    String schedule_header, schedule_detail;
    TextView header, desc;
    private TextToSpeech tts;
    FloatingActionButton fab;
    private SeekBar seekBar;
    private ImageButton save_button;
    private MyDBHelper myDBHelper;
    private HashMap<String, String> map = new HashMap<>();
    private FABProgressCircle mFabProgressCircle;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_schedules);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        mFabProgressCircle = (FABProgressCircle) findViewById(R.id.fabProgressCircle);
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

                if(myDBHelper.checkIfSaved(schedule_header)){

                    save_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_white_24dp));
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

                    save_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_border_white_24dp));
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
        super.onDestroy();

        tts.shutdown();
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
                                mFabProgressCircle.show();
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
                                mFabProgressCircle.hide();
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
        super.onStop();
    }

    @Override
    protected void onStart() {

        tts = new TextToSpeech(this, this);

        super.onStart();
    }
}
