package com.appbusters.robinpc.constitutionofindia.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.ui.ABOUT;

public class DetailSchedules extends AppCompatActivity implements TextToSpeech.OnInitListener{

    String schedule_header, schedule_detail;
    TextView header, desc;
    private TextToSpeech tts;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_schedules);

        header = (TextView) findViewById(R.id.header);
        desc = (TextView) findViewById(R.id.desc);

        Intent i = getIntent();
        schedule_header = i.getStringExtra("subTitle");
        schedule_detail = i.getStringExtra("Desc");

        header.setText(schedule_header);
        desc.setText(schedule_detail);

        fab = (FloatingActionButton) findViewById(R.id.fab);
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

    private void autoSpeak(String text) {
        if (TextUtils.isEmpty(text) || tts == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_ADD, null, "SpeakText");
        } else {
            tts.speak(text, TextToSpeech.QUEUE_ADD, null);
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
