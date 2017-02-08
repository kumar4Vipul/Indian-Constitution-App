package com.appbusters.robinpc.constitutionofindia.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.model.Data;
import com.appbusters.robinpc.constitutionofindia.model.View_Holder;

import java.util.Collections;
import java.util.List;


public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder>{

    Context context;
    Context p_context;
    List<Data> list= Collections.emptyList();
    private int position_;
    String Title, subTitle, Desc;
    View_Holder holder_;

    public Recycler_View_Adapter( List<Data> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout, initialize the View_Holder
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        p_context = parent.getContext();
        return new View_Holder(v);
    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {
        position_ = position;
        holder.subTitle.setText(list.get(position_).subTitle);
        holder_ = holder;
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick){

                    Title = list.get(position).Title;
                    subTitle = list.get(position).subTitle;
                    Desc = list.get(position).Desc;
                    holder_.intent(Title, subTitle, Desc);
                    Toast.makeText(context, "#" + (position+1) + " - " + list.get(position).subTitle + " (Long click)", Toast.LENGTH_SHORT).show();
                }
                else {
                    Title = list.get(position).Title;
                    subTitle = list.get(position).subTitle;
                    Desc = list.get(position).Desc;
                    holder_.intent(Title, subTitle, Desc);
                    Toast.makeText(context, "#" + (position+1) + " - " + list.get(position).subTitle, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
