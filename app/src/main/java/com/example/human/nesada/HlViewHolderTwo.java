package com.example.human.nesada;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.human.R;
import com.example.human.model.Parks;
import com.example.human.view.DMapsActivity;
import com.example.human.view.MapsActivity;


/**
 * Created by nesada on 1/29/17.
 */

public class HlViewHolderTwo extends RecyclerView.ViewHolder {

    private Context mContext;

    TextView name, location,type;
    ImageView gMaps;



    public HlViewHolderTwo(View itemView) {
        super(itemView);

        mContext = itemView.getContext();

        gMaps = (ImageView) itemView.findViewById(R.id.g_maps);
        name = (TextView) itemView.findViewById(R.id.name);
        location = (TextView) itemView.findViewById(R.id.location);
        type = (TextView) itemView.findViewById(R.id.type);

        gMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;

                switch (getAdapterPosition()){
                    case 0:
                        intent = new Intent(mContext, DMapsActivity.class);
                        mContext.startActivity(intent);
                        break;
                }
            }
        });

    }

    public void bind (Parks shelters){
        name.setText( shelters.getName());
        location.setText( shelters.getLocation());
        type.setText(shelters.getType());

    }


}
