package com.appbusters.robinpc.constitutionofindia.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.controller.Recycler_View_Adapter;
import com.appbusters.robinpc.constitutionofindia.model.Data;

import java.util.ArrayList;
import java.util.List;

public class respectiveSubpartsActivity extends AppCompatActivity {

    private String category;
    private List<Data> data;
    private String[] subParts, headers, desc;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respective_subparts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        }
        else if(category.equals(subParts[11])){

        }
        else if(category.equals(subParts[12])){

        }
        else if(category.equals(subParts[13])){

        }
        else if(category.equals(subParts[14])){

        }
        else if(category.equals(subParts[15])){

        }
        else if(category.equals(subParts[16])){

        }
        else if(category.equals(subParts[17])){

        }
        else if(category.equals(subParts[18])){

        }
        else if(category.equals(subParts[19])){

        }
        else if(category.equals(subParts[20])){

        }
        else if(category.equals(subParts[21])){

        }
        else if(category.equals(subParts[22])){

        }
    }

    private List<Data> fillWithData(){
        List<Data> data = new ArrayList<>();
        for(int i = 1; i <= desc.length; i++){
            data.add(new Data(" ", headers[i-1] , desc[i-1]));
        }
        return data;
    }
}
