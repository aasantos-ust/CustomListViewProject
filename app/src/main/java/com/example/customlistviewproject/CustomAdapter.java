package com.example.customlistviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    ArrayList<AndroidVersion> androidList;
    Context context;

    CustomAdapter(Context c){
        androidList = new ArrayList<>();
        this.context = c;

        String[] cNames = c.getResources().getStringArray(R.array.codeName);
        String[] apiLevel = c.getResources().getStringArray(R.array.apiLevel);
        int[] images = {R.drawable.cupcake, R.drawable.donut, R.drawable.eclair, R.drawable.froyo, R.drawable.gingerbread,
                        R.drawable.honeycomb, R.drawable.ics, R.drawable.jellybean, R.drawable.kitkat, R.drawable.lollipop};
        for(int i=0; i<cNames.length; i++){
            androidList.add(new AndroidVersion(cNames[i], apiLevel[i], images[i]));
        }

    }

    @Override
    public int getCount() {
        return androidList.size();
    }

    @Override
    public Object getItem(int i) {
        return androidList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRef = inflater.inflate(R.layout.row, viewGroup, false);
        TextView txtCode = viewRef.findViewById(R.id.androidAlias);
        TextView txtApi = viewRef.findViewById(R.id.apiLevel);
        ImageView imageLogo = viewRef.findViewById(R.id.androidLogo);

        AndroidVersion temp = androidList.get(i);

        txtCode.setText(temp.codeName);
        txtApi.setText(temp.apiLevel);
        imageLogo.setImageResource(temp.image);



        return viewRef;
    }
}
