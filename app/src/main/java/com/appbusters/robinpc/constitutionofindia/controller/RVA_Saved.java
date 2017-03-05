package com.appbusters.robinpc.constitutionofindia.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.model.Data;
import com.appbusters.robinpc.constitutionofindia.model.VH_Saved;

import java.util.Collections;
import java.util.List;

public class RVA_Saved extends RecyclerView.Adapter<VH_Saved>{

    private MyDBHelper myDBHelper;
    private int position_;
    Context context, p_context;
    VH_Saved holder_;
    List<Data> list = Collections.emptyList();

    public RVA_Saved(List<Data> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VH_Saved onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_saved,parent,false);
        p_context = parent.getContext();
        return new VH_Saved(v);

    }

    @Override
    public void onBindViewHolder(VH_Saved holder, final int position) {
        position_ = position;
        holder = holder_;
        holder.name.setText(list.get(position_).subTitle);
        holder.description.setText(list.get(position_).Desc);
        holder.unsave_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDBHelper = new MyDBHelper(p_context);
                myDBHelper.deleteItem(list.get(position_).subTitle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
