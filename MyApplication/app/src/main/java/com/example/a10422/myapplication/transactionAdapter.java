package com.example.a10422.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 10422 on 2017/5/29.
 */

public class transactionAdapter extends ArrayAdapter<transaction> {
    private int resoutceId;
    public transactionAdapter(Context context, int textViewResourceId, List<transaction> objects){
        super(context,textViewResourceId,objects);
        resoutceId = textViewResourceId;
    }
    @Override
    public View getView(int position , View convertView, ViewGroup parent){
        transaction Trans=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resoutceId,null);
        TextView transtitle=(TextView) view.findViewById(R.id.text_title);
        ImageView trans=(ImageView) view.findViewById(R.id.imageButton);
        transtitle.setText(Trans.getTitle());
        return view;
    }

}
