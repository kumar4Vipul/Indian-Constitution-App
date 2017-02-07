package com.appbusters.robinpc.constitutionofindia.model;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.appbusters.robinpc.constitutionofindia.R;

/**
 * Created by robinkamboj on 07/02/17.
 */

public class View_Holder extends RecyclerView.ViewHolder{

    public CardView cardView;
    public TextView Title;
    public TextView subTitle;
    Context context;

    public View_Holder(View itemView) {
        super(itemView);
        cardView= (CardView) itemView.findViewById(R.id.cardView);
        Title= (TextView) itemView.findViewById(R.id.Title);
        subTitle= (TextView) itemView.findViewById(R.id.subTitle);

        context = itemView.getContext();
        itemView.setTag(itemView);
        /*itemView.setOnCreateContextMenuListener(this);*/
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
