package com.example.jessymartiano.navdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.jessymartiano.navdrawer.R.id.typeActivity;
import static com.example.jessymartiano.navdrawer.R.layout.list_row;

/**
 * Created by jessymartiano on 12/01/2017.
 */

public class CustomListViewAdapter extends BaseAdapter {

    private Context mcontext;

    private ArrayList<HashMap<String,String>> activities;
    private static LayoutInflater inflater=null;



    public CustomListViewAdapter(Context context, ArrayList<HashMap<String,String>> data){

        mcontext =context;
        activities=data;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return activities.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View view1 = view;

        if(view1==null){
            view=inflater.inflate(list_row,null);

            TextView activity = (TextView) view.findViewById(typeActivity);
            TextView country= (TextView)view.findViewById(R.id.country);
            TextView price =(TextView)view.findViewById(R.id.price);
            ImageView photo = (ImageView) view.findViewById(R.id.photo);

            HashMap<String,String> tActivity= new HashMap<>();

            tActivity=activities.get(i);

// donnees a recuperer du serveur!

            activity.setText(tActivity.get("typeActivity"));
            country.setText(tActivity.get("Country"));
            price.setText(tActivity.get("Price"));
            photo.setImageDrawable(mcontext.getResources().getDrawable(R.mipmap.ic_launcher));

        }

        return view;
    }
}
