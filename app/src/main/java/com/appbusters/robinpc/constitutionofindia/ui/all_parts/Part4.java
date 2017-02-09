package com.appbusters.robinpc.constitutionofindia.ui.all_parts;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.controller.Recycler_View_Adapter;
import com.appbusters.robinpc.constitutionofindia.model.Data;
import com.appbusters.robinpc.constitutionofindia.ui.ABOUT;

import java.util.ArrayList;
import java.util.List;

public class Part4 extends AppCompatActivity {

    String[] headers, desc;
    List<Data> data;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part4);

        headers = getResources().getStringArray(R.array.part_4);
        desc = new String[]{getString(R.string.article36),getString(R.string.article37),
                getString(R.string.article38),getString(R.string.article39),
                getString(R.string.article40),getString(R.string.article41),
                getString(R.string.article42),getString(R.string.article43),
                getString(R.string.article43A),getString(R.string.article43B),
                getString(R.string.article44),getString(R.string.article45),
                getString(R.string.article46),getString(R.string.article47),
                getString(R.string.article48),getString(R.string.article48A),
                getString(R.string.article49),getString(R.string.article50),
                getString(R.string.article51)};

        data = fillWithData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    private List<Data> fillWithData(){
        List<Data> data = new ArrayList<>();
        for(int i = 1; i<=headers.length; i++){
            data.add(new Data(" ", headers[i-1], desc[i-1]));
        }
        return data;
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


    /*
    public void onClick(View v){

        android.support.v7.app.AlertDialog.Builder alert= new android.support.v7.app.AlertDialog.Builder(this);
        String[] array={getString(R.string.article36),getString(R.string.article37),
                getString(R.string.article38),getString(R.string.article39),
                getString(R.string.article40),getString(R.string.article41),
                getString(R.string.article42),getString(R.string.article43),
                getString(R.string.article43A),getString(R.string.article43B),
                getString(R.string.article44),getString(R.string.article45),
                getString(R.string.article46),getString(R.string.article47),
                getString(R.string.article48),getString(R.string.article48A),
                getString(R.string.article49),getString(R.string.article50),
                getString(R.string.article51)};

        switch (v.getId()){
            case R.id.four36:
            {
                alert.setMessage(array[0]).setIcon(R.drawable.dialog).setTitle("Article 36").create().show();
                break;
            }
            case R.id.four37:
            {
                alert.setMessage(array[1]).setIcon(R.drawable.dialog).setTitle("Article 37").create().show();
                break;
            }
            case R.id.four38:
            {
                alert.setMessage(array[2]).setIcon(R.drawable.dialog).setTitle("Article 38").create().show();
                break;
            }
            case R.id.four39:
            {
                alert.setMessage(array[3]).setIcon(R.drawable.dialog).setTitle("Article 39").create().show();
                break;
            }
            case R.id.four39A:
            {
                alert.setMessage(array[4]).setIcon(R.drawable.dialog).setTitle("Article 39A").create().show();
                break;
            }
            case R.id.four40:
            {
                alert.setMessage(array[5]).setIcon(R.drawable.dialog).setTitle("Article 40").create().show();
                break;
            }
            case R.id.four41:
            {
                alert.setMessage(array[6]).setIcon(R.drawable.dialog).setTitle("Article 41").create().show();
                break;
            }
            case R.id.four42:
            {
                alert.setMessage(array[7]).setIcon(R.drawable.dialog).setTitle("Article 42").create().show();
                break;
            }
            case R.id.four43:
            {
                alert.setMessage(array[8]).setIcon(R.drawable.dialog).setTitle("Article 43").create().show();
                break;
            }
            case R.id.four43A:
            {
                alert.setMessage(array[9]).setIcon(R.drawable.dialog).setTitle("Article 43A").create().show();
                break;
            }
            case R.id.four43B:
            {
                alert.setMessage(array[10]).setIcon(R.drawable.dialog).setTitle("Article 43B").create().show();
                break;
            }
            case R.id.four44:
            {
                alert.setMessage(array[11]).setIcon(R.drawable.dialog).setTitle("Article 44").create().show();
                break;
            }
            case R.id.four45:
            {
                alert.setMessage(array[12]).setIcon(R.drawable.dialog).setTitle("Article 45").create().show();
                break;
            }
            case R.id.four46:
            {
                alert.setMessage(array[13]).setIcon(R.drawable.dialog).setTitle("Article 46").create().show();
                break;
            }
            case R.id.four47:
            {
                alert.setMessage(array[14]).setIcon(R.drawable.dialog).setTitle("Article 47").create().show();
                break;
            }
            case R.id.four48:
            {
                alert.setMessage(array[15]).setIcon(R.drawable.dialog).setTitle("Article 48").create().show();
                break;
            }
            case R.id.four48A:
            {
                alert.setMessage(array[16]).setIcon(R.drawable.dialog).setTitle("Article 48A").create().show();
                break;
            }
            case R.id.four49:
            {
                alert.setMessage(array[17]).setIcon(R.drawable.dialog).setTitle("Article 49").create().show();
                break;
            }
            case R.id.four50:
            {
                alert.setMessage(array[18]).setIcon(R.drawable.dialog).setTitle("Article 50").create().show();
                break;
            }
            case R.id.four51:
            {
                alert.setMessage(array[19]).setIcon(R.drawable.dialog).setTitle("Article 51").create().show();
                break;
            }
        }
    }*/


}
