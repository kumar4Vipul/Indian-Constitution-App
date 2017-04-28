package com.appbusters.robinpc.constitutionofindia.controller;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.model.Data;
import com.appbusters.robinpc.constitutionofindia.model.View_Holder;
import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.animation.DefaultAnimations;
import com.willowtreeapps.spruce.sort.LinearSort;

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
        animateViewItem(holder.cardView);
        holder_ = holder;
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick){

                    Title = list.get(position).Title;
                    subTitle = list.get(position).subTitle;
                    Desc = list.get(position).Desc;
                    holder_.intent(Title, subTitle, Desc);
                }
                else {
                    Title = list.get(position).Title;
                    subTitle = list.get(position).subTitle;
                    Desc = list.get(position).Desc;
                    holder_.intent(Title, subTitle, Desc);
                }
            }
        });
    }

    public void animateViewItem(CardView item){
        Animator[] animators = new Animator[]{
                DefaultAnimations.fadeInAnimator(item, 500L),
                DefaultAnimations.shrinkAnimator(item, 500L)
        };
        LinearSort linearSort = new LinearSort(100L, false, LinearSort.Direction.TOP_TO_BOTTOM);
        Animator spruceAnimator = new Spruce.SpruceBuilder(item)
                .sortWith(linearSort)
                .animateWith(animators)
                .start();
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
