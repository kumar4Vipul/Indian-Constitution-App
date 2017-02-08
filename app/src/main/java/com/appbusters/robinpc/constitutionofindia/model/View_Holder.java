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

/**
 * Created by robinkamboj on 07/02/17.
 */

public class View_Holder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public CardView cardView;
    public TextView Title;
    public TextView subTitle;
    private ItemClickListener clickListener;
    Context context;

    public View_Holder(View itemView) {
        super(itemView);
        cardView= (CardView) itemView.findViewById(R.id.cardView);
        Title= (TextView) itemView.findViewById(R.id.Title);
        subTitle= (TextView) itemView.findViewById(R.id.subTitle);

        context = itemView.getContext();
        itemView.setTag(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        /*itemView.setOnCreateContextMenuListener(this);*/
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

    public void intent(String Title, String subTitle, String TT){
        Intent i = new Intent(context, DetailSchedules.class);
        i.putExtra("Title", Title);
        i.putExtra("subTitle", subTitle);
        i.putExtra("TT", TT);
        context.startActivity(i);
    }

}
