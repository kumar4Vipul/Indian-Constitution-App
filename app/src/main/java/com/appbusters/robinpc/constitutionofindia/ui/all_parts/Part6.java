package com.appbusters.robinpc.constitutionofindia.ui.all_parts;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
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

public class Part6 extends AppCompatActivity {

    String[] headers, desc;
    List<Data> data;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part6);

        headers = getResources().getStringArray(R.array.part_5);
        desc = new String[]{getString(R.string.article52),getString(R.string.article53),getString(R.string.article54),
                getString(R.string.article55),getString(R.string.article56),getString(R.string.article57),
                getString(R.string.article58),getString(R.string.article59),getString(R.string.article60),
                getString(R.string.article61),getString(R.string.article62),getString(R.string.article63),
                getString(R.string.article64),getString(R.string.article65),getString(R.string.article66),
                getString(R.string.article67),getString(R.string.article68),getString(R.string.article69),
                getString(R.string.article70),getString(R.string.article71),getString(R.string.article72),
                getString(R.string.article73),getString(R.string.article74),getString(R.string.article75),
                getString(R.string.article76),getString(R.string.article77),getString(R.string.article78),
                getString(R.string.article79),getString(R.string.article80),getString(R.string.article81),
                getString(R.string.article82),getString(R.string.article83),getString(R.string.article84),
                getString(R.string.article85),getString(R.string.article86),getString(R.string.article87),
                getString(R.string.article88),getString(R.string.article89),getString(R.string.article90),
                getString(R.string.article91),getString(R.string.article92),getString(R.string.article93),
                getString(R.string.article94),getString(R.string.article95),getString(R.string.article96),
                getString(R.string.article97),getString(R.string.article98),getString(R.string.article99),
                getString(R.string.article100),getString(R.string.article101),getString(R.string.article52),
                getString(R.string.article103),getString(R.string.article104),getString(R.string.article52),
                getString(R.string.article106),getString(R.string.article107),getString(R.string.article52),
                getString(R.string.article109),getString(R.string.article110),getString(R.string.article52),
                getString(R.string.article112),getString(R.string.article113),getString(R.string.article52),
                getString(R.string.article115),getString(R.string.article116),getString(R.string.article52),
                getString(R.string.article118),getString(R.string.article119),getString(R.string.article52),
                getString(R.string.article121),getString(R.string.article122),getString(R.string.article52),
                getString(R.string.article124),getString(R.string.article125),getString(R.string.article52),
                getString(R.string.article127),getString(R.string.article128),getString(R.string.article52),
                getString(R.string.article130),getString(R.string.article131),getString(R.string.article131A),
                getString(R.string.article132),getString(R.string.article133),getString(R.string.article134),
                getString(R.string.article134A),getString(R.string.article135),getString(R.string.article136),
                getString(R.string.article137),getString(R.string.article138),getString(R.string.article139),
                getString(R.string.article139A),getString(R.string.article140),getString(R.string.article141),
                getString(R.string.article142),getString(R.string.article143),getString(R.string.article144),
                getString(R.string.article144A),getString(R.string.article145),getString(R.string.article146),
                getString(R.string.article147),getString(R.string.article148),getString(R.string.article149),
                getString(R.string.article150),getString(R.string.article151)};

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
        getMenuInflater().inflate( R.menu.menu_main, menu);
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
        }
        return super.onOptionsItemSelected(item);
    }

}
