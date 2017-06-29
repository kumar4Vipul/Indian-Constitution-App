package com.appbusters.robinpc.constitutionofindia.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.controller.Recycler_View_Adapter;
import com.appbusters.robinpc.constitutionofindia.model.Data;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;

public class respectiveSubpartsActivity extends AppCompatActivity {

    private String category;
    private List<Data> data;
    private String[] subParts, headers, desc;
    private RecyclerView recyclerView;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respective_subparts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString("subparts_activity", "opened");

        mFirebaseAnalytics.logEvent("activity_subparts", bundle);

        subParts = getResources().getStringArray(R.array.partsList);
        TextView textView = (TextView) findViewById(R.id.textView);
        category = getIntent().getStringExtra("subTitle");
        textView.setText(category);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        inflateData();
        data = fillWithData();
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    private void inflateData(){
        if(category.equals(subParts[0])){
            headers = getResources().getStringArray(R.array.part_1);
            desc = new String[]{getString(R.string.article1),getString(R.string.article2),getString(R.string.article2A),
                    getString(R.string.article3),getString(R.string.article4)};
        }
        else if(category.equals(subParts[1])){
            headers = getResources().getStringArray(R.array.part_2);
            desc = new String[]{getString(R.string.article5),getString(R.string.article6),getString(R.string.article7),
                    getString(R.string.article8),getString(R.string.article9),getString(R.string.article10),
                    getString(R.string.article11)};
        }
        else if(category.equals(subParts[2])){
            headers = getResources().getStringArray(R.array.part_3);
            desc = new String[]{getString(R.string.article12),getString(R.string.article13),
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
        }
        else if(category.equals(subParts[3])){
            headers = getResources().getStringArray(R.array.part_4);
            desc = new String[]{getString(R.string.article36),getString(R.string.article37),
                    getString(R.string.article38),getString(R.string.article39),getString(R.string.article39A),
                    getString(R.string.article40),getString(R.string.article41),
                    getString(R.string.article42),getString(R.string.article43),
                    getString(R.string.article43A),getString(R.string.article43B),
                    getString(R.string.article44),getString(R.string.article45),
                    getString(R.string.article46),getString(R.string.article47),
                    getString(R.string.article48),getString(R.string.article48A),
                    getString(R.string.article49),getString(R.string.article50),
                    getString(R.string.article51)};
        }
        else if(category.equals(subParts[4])){
            headers = getResources().getStringArray(R.array.part_4A);
            desc = new String[]{getString(R.string.article51A)};
        }
        else if(category.equals(subParts[5])){
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
        }
        else if(category.equals(subParts[6])){
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
        }
        else if(category.equals(subParts[7])){
            headers = getResources().getStringArray(R.array.part_7);
            desc = new String[]{getString(R.string.article238)};
        }
        else if(category.equals(subParts[8])){
            headers = getResources().getStringArray(R.array.part_8);
            desc = new String[]{getString(R.string.article239),getString(R.string.article239A),
                    getString(R.string.article239AA),getString(R.string.article239AB),getString(R.string.article239B),
                    getString(R.string.article240),getString(R.string.article241),getString(R.string.article242)};
        }
        else if(category.equals(subParts[9])){
            headers = getResources().getStringArray(R.array.part_9);
            desc = new String[]{getString(R.string.article243),getString(R.string.article243A),getString(R.string.article243B),
                    getString(R.string.article243C),getString(R.string.article243D),getString(R.string.article243E),
                    getString(R.string.article243F),getString(R.string.article243G),getString(R.string.article243H),
                    getString(R.string.article243I),getString(R.string.article243J),getString(R.string.article243K),
                    getString(R.string.article243L),getString(R.string.article243M),getString(R.string.article243N),
                    getString(R.string.article243O)};
        }
        else if(category.equals(subParts[10])){
            headers = getResources().getStringArray(R.array.part_9A);
            desc = new String[]{getString(R.string.article243P),getString(R.string.article243Q),getString(R.string.article243R),
                    getString(R.string.article243S),getString(R.string.article243T),getString(R.string.article243U),
                    getString(R.string.article243V),getString(R.string.article243W),getString(R.string.article243X),
                    getString(R.string.article243Y),getString(R.string.article243Z),getString(R.string.article243ZA),
                    getString(R.string.article243ZB),getString(R.string.article243ZC),getString(R.string.article243ZD),
                    getString(R.string.article243ZE),getString(R.string.article243ZF),getString(R.string.article243ZG)};
        }
        else if(category.equals(subParts[11])){
            headers = getResources().getStringArray(R.array.part_9B);
            desc = new String[]{getString(R.string.article243H),getString(R.string.article243I),getString(R.string.article243J),
                    getString(R.string.article243K),getString(R.string.article243L),getString(R.string.article243M),
                    getString(R.string.article243N),getString(R.string.article243O),getString(R.string.article243P),
                    getString(R.string.article243Q),getString(R.string.article243R),getString(R.string.article243S),
                    getString(R.string.article243T)};
        }
        else if(category.equals(subParts[12])){
            headers = getResources().getStringArray(R.array.part_10);
            desc = new String[]{getString(R.string.article244), getString(R.string.article244A)};
        }
        else if(category.equals(subParts[13])){
            headers = getResources().getStringArray(R.array.part_11);
            desc = new String[]{getString(R.string.article245),getString(R.string.article246),getString(R.string.article247),
                    getString(R.string.article248),getString(R.string.article249),getString(R.string.article250),
                    getString(R.string.article251),getString(R.string.article252),getString(R.string.article253),
                    getString(R.string.article254),getString(R.string.article255),getString(R.string.article256),
                    getString(R.string.article257),getString(R.string.article257A),getString(R.string.article258),
                    getString(R.string.article258A),getString(R.string.article259),getString(R.string.article260),
                    getString(R.string.article261),getString(R.string.article262),getString(R.string.article263)
            };
        }
        else if(category.equals(subParts[14])){
            headers = getResources().getStringArray(R.array.part_12);
            desc = new String[]{getString(R.string.article264),getString(R.string.article265),getString(R.string.article266),
                    getString(R.string.article267),getString(R.string.article268),getString(R.string.article268A),
                    getString(R.string.article269),getString(R.string.article270),getString(R.string.article271),
                    getString(R.string.article272),getString(R.string.article273),getString(R.string.article274),
                    getString(R.string.article275),getString(R.string.article276),getString(R.string.article277),
                    getString(R.string.article278),getString(R.string.article279),getString(R.string.article280),
                    getString(R.string.article281),getString(R.string.article282),getString(R.string.article283),
                    getString(R.string.article284),getString(R.string.article285),getString(R.string.article286),
                    getString(R.string.article287),getString(R.string.article288),getString(R.string.article289),
                    getString(R.string.article290),getString(R.string.article290A),getString(R.string.article291),
                    getString(R.string.article292),getString(R.string.article293),getString(R.string.article294),
                    getString(R.string.article295),getString(R.string.article296),getString(R.string.article297),
                    getString(R.string.article298),getString(R.string.article299),getString(R.string.article300),
                    getString(R.string.article300)};
        }
        else if(category.equals(subParts[15])){
            headers = getResources().getStringArray(R.array.part_13);
            desc = new String[]{
                    getString(R.string.article301),getString(R.string.article302),getString(R.string.article303),
                    getString(R.string.article304),getString(R.string.article305),getString(R.string.article306),
                    getString(R.string.article307)};
        }
        else if(category.equals(subParts[16])){
            headers = getResources().getStringArray(R.array.part_14);
            desc = new String[]{
                    getString(R.string.article308),getString(R.string.article309),getString(R.string.article310),
                    getString(R.string.article311),getString(R.string.article312),getString(R.string.article312A),
                    getString(R.string.article313),getString(R.string.article314),getString(R.string.article315),
                    getString(R.string.article316),getString(R.string.article317),getString(R.string.article318),
                    getString(R.string.article319),getString(R.string.article320),getString(R.string.article321),
                    getString(R.string.article322),getString(R.string.article323)};
        }
        else if(category.equals(subParts[17])){
            headers = getResources().getStringArray(R.array.part_14A);
            desc = new String[]{
                    getString(R.string.article323a),getString(R.string.article323b)};
        }
        else if(category.equals(subParts[18])){
            headers = getResources().getStringArray(R.array.part_15);
            desc = new String[]{
                    getString(R.string.article324),getString(R.string.article325),getString(R.string.article326),
                    getString(R.string.article327),getString(R.string.article328),getString(R.string.article329),
                    getString(R.string.article329a)};
        }
        else if(category.equals(subParts[19])){
            headers = getResources().getStringArray(R.array.part_16);
            desc = new String[]{
                    getString(R.string.article330),getString(R.string.article331),getString(R.string.article332),
                    getString(R.string.article333),getString(R.string.article334),getString(R.string.article335),
                    getString(R.string.article336),getString(R.string.article337),getString(R.string.article338),
                    getString(R.string.article338a),getString(R.string.article339),getString(R.string.article340),
                    getString(R.string.article341),getString(R.string.article342)};
        }
        else if(category.equals(subParts[20])){
            headers = getResources().getStringArray(R.array.part_17);
            desc = new String[]{
                    getString(R.string.article343),getString(R.string.article344),getString(R.string.article345),
                    getString(R.string.article346),getString(R.string.article347),getString(R.string.article348),
                    getString(R.string.article349),getString(R.string.article350),getString(R.string.article350a),
                    getString(R.string.article350b),getString(R.string.article351)};
        }
        else if(category.equals(subParts[21])){
            headers = getResources().getStringArray(R.array.part_18);
            desc = new String[]{
                    getString(R.string.article352),getString(R.string.article353),getString(R.string.article354),
                    getString(R.string.article355),getString(R.string.article356),getString(R.string.article357),
                    getString(R.string.article358),getString(R.string.article359),getString(R.string.article359a),
                    getString(R.string.article360)};

        }
        else if(category.equals(subParts[22])){
            headers = getResources().getStringArray(R.array.part_19);
            desc = new String[]{
                    getString(R.string.article361),getString(R.string.article361a),getString(R.string.article361b),
                    getString(R.string.article362),getString(R.string.article363),getString(R.string.article363a),
                    getString(R.string.article364),getString(R.string.article365),getString(R.string.article366),
                    getString(R.string.article367)};
        }
        else if(category.equals(subParts[23])){
            headers = getResources().getStringArray(R.array.part_20);
            desc = new String[]{
                    getString(R.string.article368)};
        }
        else if(category.equals(subParts[24])){
            headers = getResources().getStringArray(R.array.part_21);
            desc = new String[]{
                    getString(R.string.article369),getString(R.string.article370),getString(R.string.article371),
                    getString(R.string.article371a),getString(R.string.article371b),getString(R.string.article371c),
                    getString(R.string.article371d),getString(R.string.article371e),getString(R.string.article371f),
                    getString(R.string.article371g),getString(R.string.article371h),getString(R.string.article371i),
                /*getString(R.string.article371j), */                                                //ERROR
                    getString(R.string.article372),getString(R.string.article372a),getString(R.string.article373),
                    getString(R.string.article374),getString(R.string.article375),getString(R.string.article376),
                    getString(R.string.article377),getString(R.string.article378),getString(R.string.article378a),
                    getString(R.string.article379),getString(R.string.article392)};

        }
        else if(category.equals(subParts[25])){
            headers = getResources().getStringArray(R.array.part_22);
            desc = new String[]{
                    getString(R.string.article393),getString(R.string.article394),getString(R.string.article394a),
                    getString(R.string.article395)};
        }
    }

    private List<Data> fillWithData(){
        List<Data> data = new ArrayList<>();
        for(int i = 1; i <= desc.length; i++){
            data.add(new Data(" ", headers[i-1] , desc[i-1]));
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
