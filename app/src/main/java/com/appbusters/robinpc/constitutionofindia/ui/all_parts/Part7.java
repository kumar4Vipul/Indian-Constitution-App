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

public class Part7 extends AppCompatActivity {

    String[] headers, desc;
    RecyclerView recyclerView;
    List<Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part7);

        headers = getResources().getStringArray(R.array.part_6);
        desc = new String[]{getString(R.string.article152), getString(R.string.article153), getString(R.string.article154),
                getString(R.string.article155), getString(R.string.article156), getString(R.string.article157),
                getString(R.string.article158), getString(R.string.article159), getString(R.string.article160),
                getString(R.string.article161), getString(R.string.article162), getString(R.string.article163),
                getString(R.string.article164), getString(R.string.article165), getString(R.string.article166),
                getString(R.string.article167), getString(R.string.article168), getString(R.string.article169),
                getString(R.string.article170), getString(R.string.article171), getString(R.string.article172),
                getString(R.string.article173), getString(R.string.article174), getString(R.string.article175),
                getString(R.string.article176), getString(R.string.article177), getString(R.string.article178),
                getString(R.string.article179), getString(R.string.article180), getString(R.string.article181),
                getString(R.string.article182), getString(R.string.article183), getString(R.string.article184),
                getString(R.string.article185), getString(R.string.article186), getString(R.string.article187),
                getString(R.string.article188), getString(R.string.article189), getString(R.string.article190),
                getString(R.string.article191), getString(R.string.article192), getString(R.string.article193),
                getString(R.string.article194), getString(R.string.article195), getString(R.string.article196),
                getString(R.string.article197), getString(R.string.article198), getString(R.string.article199),
                getString(R.string.article200), getString(R.string.article201), getString(R.string.article202),
                getString(R.string.article203), getString(R.string.article204), getString(R.string.article205),
                getString(R.string.article206), getString(R.string.article207), getString(R.string.article208),
                getString(R.string.article209), getString(R.string.article210), getString(R.string.article211),
                getString(R.string.article212), getString(R.string.article213), getString(R.string.article214),
                getString(R.string.article215), getString(R.string.article216), getString(R.string.article217),
                getString(R.string.article218), getString(R.string.article219), getString(R.string.article220),
                getString(R.string.article221), getString(R.string.article222), getString(R.string.article223),
                getString(R.string.article224),getString(R.string.article224A), getString(R.string.article225), getString(R.string.article226),getString(R.string.article226A),
                getString(R.string.article227), getString(R.string.article228),getString(R.string.article228A), getString(R.string.article229),
                getString(R.string.article230), getString(R.string.article231), getString(R.string.article233),
                getString(R.string.article234), getString(R.string.article235), getString(R.string.article236),
                getString(R.string.article237)};

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


    public void article152(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article152)).create();
        builder.show();
    }
    public void article153(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article153)).create();
        builder.show();
    }
    public void article154(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article154)).create();
        builder.show();
    }
    public void article155(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article155)).create();
        builder.show();
    }
    public void article156(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article156)).create();
        builder.show();
    }
    public void article157(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article157)).create();
        builder.show();
    }
    public void article158(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article158)).create();
        builder.show();
    }
    public void article159(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article159)).create();
        builder.show();
    }
    public void article160(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article160)).create();
        builder.show();
    }
    public void article161(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article161)).create();
        builder.show();
    }
    public void article162(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article162)).create();
        builder.show();
    }
    public void article163(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article163)).create();
        builder.show();
    }
    public void article164(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article164)).create();
        builder.show();
    }
    public void article165(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article165)).create();
        builder.show();
    }
    public void article166(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article166)).create();
        builder.show();
    }
    public void article167(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article167)).create();
        builder.show();
    }
    public void article168(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article168)).create();
        builder.show();
    }
    public void article169(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article169)).create();
        builder.show();
    }
    public void article170(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article170)).create();
        builder.show();
    }
    public void article171(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article171)).create();
        builder.show();
    }
    public void article172(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article172)).create();
        builder.show();
    }
    public void article173(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article173)).create();
        builder.show();
    }
    public void article174(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article174)).create();
        builder.show();
    }
    public void article175(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article175)).create();
        builder.show();
    }
    public void article176(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article176)).create();
        builder.show();
    }
    public void article177(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article177)).create();
        builder.show();
    }
    public void article178(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article178)).create();
        builder.show();
    }
    public void article179(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article179)).create();
        builder.show();
    }
    public void article180(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article180)).create();
        builder.show();
    }
    public void article181(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article181)).create();
        builder.show();
    }
    public void article182(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article182)).create();
        builder.show();
    }
    public void article183(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article183)).create();
        builder.show();
    }
    public void article184(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article184)).create();
        builder.show();
    }
    public void article185(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article185)).create();
        builder.show();
    }
    public void article186(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article186)).create();
        builder.show();
    }
    public void article187(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article187)).create();
        builder.show();
    }
    public void article188(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article188)).create();
        builder.show();
    }
    public void article189(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article189)).create();
        builder.show();
    }
    public void article190(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article190)).create();
        builder.show();
    }
    public void article191(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article191)).create();
        builder.show();
    }
    public void article192(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article192)).create();
        builder.show();
    }
    public void article193(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article193)).create();
        builder.show();
    }
    public void article194(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article194)).create();
        builder.show();
    }
    public void article195(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article195)).create();
        builder.show();
    }
    public void article196(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article196)).create();
        builder.show();
    }
    public void article197(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article197)).create();
        builder.show();
    }
    public void article198(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article198)).create();
        builder.show();
    }
    public void article199(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article199)).create();
        builder.show();
    }
    public void article200(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article200)).create();
        builder.show();
    }
    public void article201(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article201)).create();
        builder.show();
    }
    public void article202(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article202)).create();
        builder.show();
    }
    public void article203(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article203)).create();
        builder.show();
    }
    public void article204(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article204)).create();
        builder.show();
    }
    public void article205(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article205)).create();
        builder.show();
    }
    public void article206(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article206)).create();
        builder.show();
    }
    public void article207(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article207)).create();
        builder.show();
    }
    public void article208(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article208)).create();
        builder.show();
    }
    public void article209(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article209)).create();
        builder.show();
    }
    public void article210(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article210)).create();
        builder.show();
    }
    public void article211(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article211)).create();
        builder.show();
    }
    public void article212(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article212)).create();
        builder.show();
    }
    public void article213(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article213)).create();
        builder.show();
    }
    public void article214(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article214)).create();
        builder.show();
    }
    public void article215(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article215)).create();
        builder.show();
    }
    public void article216(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article216)).create();
        builder.show();
    }
    public void article217(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article217)).create();
        builder.show();
    }
    public void article218(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article218)).create();
        builder.show();
    }
    public void article219(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article219)).create();
        builder.show();
    }
    public void article220(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article220)).create();
        builder.show();
    }
    public void article221(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article221)).create();
        builder.show();
    }
    public void article222(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article222)).create();
        builder.show();
    }
    public void article223(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article223)).create();
        builder.show();
    }
    public void article224(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article224)).create();
        builder.show();
    }
    public void article224A(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article224A)).create();
        builder.show();
    }
    public void article225(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article225)).create();
        builder.show();
    }
    public void article226(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article226)).create();
        builder.show();
    }
    public void article226A(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article226A)).create();
        builder.show();
    }
    public void article227(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article227)).create();
        builder.show();
    }
    public void article228(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article228)).create();
        builder.show();
    }
    public void article228A(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article228A)).create();
        builder.show();
    }
    public void article229(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article229)).create();
        builder.show();
    }

    public void article230(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article230)).create();
        builder.show();
    }
    public void article231(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article231)).create();
        builder.show();
    }
    public void article233(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article233)).create();
        builder.show();
    }
    public void article233A(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article233A)).create();
        builder.show();
    }
    public void article234(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article234)).create();
        builder.show();
    }
    public void article235(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article235)).create();
        builder.show();
    }
    public void article236(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article236)).create();
        builder.show();
    }
    public void article237(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(this.getString(R.string.article237)).create();
        builder.show();
    }

}
