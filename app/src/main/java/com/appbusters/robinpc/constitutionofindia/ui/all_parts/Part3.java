package com.appbusters.robinpc.constitutionofindia.ui.all_parts;

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

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.ui.ABOUT;

public class Part3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);

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

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        String[] array={getString(R.string.article12),getString(R.string.article13),
                getString(R.string.article14),getString(R.string.article15),
                getString(R.string.article16),getString(R.string.article17),
                getString(R.string.article18),getString(R.string.article19),
                getString(R.string.article20),getString(R.string.article21),
                getString(R.string.article21A),getString(R.string.article22),
                getString(R.string.article23),getString(R.string.article24),
                getString(R.string.article25),getString(R.string.article26),
                getString(R.string.article27),getString(R.string.article28),
                getString(R.string.article29),getString(R.string.article30),
                getString(R.string.article31),getString(R.string.article31A),
                getString(R.string.article31B),getString(R.string.article31C),
                getString(R.string.article31D),getString(R.string.article32),
                getString(R.string.article32A),getString(R.string.article33),
                getString(R.string.article34),getString(R.string.article35)};

        switch (v.getId()){
            case R.id.three12:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 12").create().show();
                break;
            }
            case R.id.three13:
            {
                alert.setMessage(array[1]).setIcon(R.drawable.dialog).setTitle("Article 13").create().show();
                break;
            }
            case R.id.three14:
            {
                alert.setMessage(array[2]).setIcon(R.drawable.dialog).setTitle("Article 14").create().show();
                break;
            }
            case R.id.three15:
            {
                alert.setMessage(array[3]).setIcon(R.drawable.dialog).setTitle("Article 15").create().show();
                break;
            }
            case R.id.three16:
            {
                alert.setMessage(array[4]).setIcon(R.drawable.dialog).setTitle("Article 16").create().show();
                break;
            }
            case R.id.three17:
            {
                alert.setMessage(array[5]).setIcon(R.drawable.dialog).setTitle("Article 17").create().show();
                break;
            }
            case R.id.three18:
            {
                alert.setMessage(array[6]).setIcon(R.drawable.dialog).setTitle("Article 18").create().show();
                break;
            }
            case R.id.three19:
            {
                alert.setMessage(array[7]).setIcon(R.drawable.dialog).setTitle("Article 19").create().show();
                break;
            }
            case R.id.three20:
            {
                alert.setMessage(array[8]).setIcon(R.drawable.dialog).setTitle("Article 20").create().show();
                break;
            }
            case R.id.three21:
            {
                alert.setMessage(array[9]).setIcon(R.drawable.dialog).setTitle("Article 21").create().show();
                break;
            }
            case R.id.three21A:
            {
                alert.setMessage(array[9]).setIcon(R.drawable.dialog).setTitle("Article 21A").create().show();
                break;
            }
            case R.id.three22:
            {
                alert.setMessage(array[10]).setIcon(R.drawable.dialog).setTitle("Article 22").create().show();
                break;
            }
            case R.id.three23:
            {
                alert.setMessage(array[11]).setIcon(R.drawable.dialog).setTitle("Article 23").create().show();
                break;
            }
            case R.id.three24:
            {
                alert.setMessage(array[12]).setIcon(R.drawable.dialog).setTitle("Article 24").create().show();
                break;
            }
            case R.id.three25:
            {
                alert.setMessage(array[13]).setIcon(R.drawable.dialog).setTitle("Article 25").create().show();
                break;
            }
            case R.id.three26:
            {
                alert.setMessage(array[14]).setIcon(R.drawable.dialog).setTitle("Article 26").create().show();
                break;
            }
            case R.id.three27:
            {
                alert.setMessage(array[15]).setIcon(R.drawable.dialog).setTitle("Article 27").create().show();
                break;
            }
            case R.id.three28:
            {
                alert.setMessage(array[16]).setIcon(R.drawable.dialog).setTitle("Article 28").create().show();
                break;
            }
            case R.id.three29:
            {
                alert.setMessage(array[17]).setIcon(R.drawable.dialog).setTitle("Article 29").create().show();
                break;
            }
            case R.id.three30:
            {
                alert.setMessage(array[18]).setIcon(R.drawable.dialog).setTitle("Article 30").create().show();
                break;
            }
            case R.id.three31:
            {
                alert.setMessage(array[19]).setIcon(R.drawable.dialog).setTitle("Article 31").create().show();
                break;
            }
            case R.id.three31A:
            {
                alert.setMessage(array[20]).setIcon(R.drawable.dialog).setTitle("Article 31A").create().show();
                break;
            }
            case R.id.three31B:
            {
                alert.setMessage(array[21]).setIcon(R.drawable.dialog).setTitle("Article 31B").create().show();
                break;
            }
            case R.id.three31C:
            {
                alert.setMessage(array[22]).setIcon(R.drawable.dialog).setTitle("Article 31C").create().show();
                break;
            }
            case R.id.three31D:
            {
                alert.setMessage(array[23]).setIcon(R.drawable.dialog).setTitle("Article 31D").create().show();
                break;
            }
            case R.id.three32:
            {
                alert.setMessage(array[24]).setIcon(R.drawable.dialog).setTitle("Article 32").create().show();
                break;
            }
            case R.id.three32A:
            {
                alert.setMessage(array[25]).setIcon(R.drawable.dialog).setTitle("Article 32A").create().show();
                break;
            }
            case R.id.three33:
            {
                alert.setMessage(array[26]).setIcon(R.drawable.dialog).setTitle("Article 33").create().show();
                break;
            }
            case R.id.three34:
            {
                alert.setMessage(array[27]).setIcon(R.drawable.dialog).setTitle("Article 34").create().show();
                break;
            }
            case R.id.three35:
            {
                alert.setMessage(array[28]).setIcon(R.drawable.dialog).setTitle("Article 35").create().show();
                break;
            }
        }
    }

}
