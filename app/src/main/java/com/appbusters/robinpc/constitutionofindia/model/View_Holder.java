package com.appbusters.robinpc.constitutionofindia.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.appbusters.robinpc.constitutionofindia.R;
import com.appbusters.robinpc.constitutionofindia.controller.ItemClickListener;
import com.appbusters.robinpc.constitutionofindia.view.DetailSchedules;

public class View_Holder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public TextView Title;
    public TextView subTitle;
    public CardView cardView;
    private ItemClickListener clickListener;
    Context context;

    public View_Holder(View itemView) {
        super(itemView);
        subTitle= (TextView) itemView.findViewById(R.id.subTitle);
        cardView = (CardView) itemView.findViewById(R.id.cardView);

        context = itemView.getContext();
        itemView.setTag(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setClickListener(ItemClickListener itemClickListener){
        this.clickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        clickListener.onClick(view, getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View view) {
        clickListener.onClick(view, getAdapterPosition(), true);
        return true;
    }

    public void intent(String Title, String subTitle, String Desc){
        Intent i = new Intent(context, DetailSchedules.class);
        i.putExtra("Title", Title);
        i.putExtra("subTitle", subTitle);
        i.putExtra("Desc", Desc);
        context.startActivity(i);
    }

}
