package com.appbusters.robinpc.constitutionofindia.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.appbusters.robinpc.constitutionofindia.R;

public class VH_Saved extends RecyclerView.ViewHolder{

    public TextView name, description;
    public ImageButton unsave_button;
    public SeekBar seekBar;

    public VH_Saved(View itemView) {
        super(itemView);

        seekBar = (SeekBar) itemView.findViewById(R.id.seekbar);
        name = (TextView) itemView.findViewById(R.id.name);
        description = (TextView) itemView.findViewById(R.id.description);
        unsave_button = (ImageButton) itemView.findViewById(R.id.unsave_button);

    }
}
