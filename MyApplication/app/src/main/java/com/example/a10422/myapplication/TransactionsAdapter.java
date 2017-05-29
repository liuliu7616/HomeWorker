package com.example.a10422.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 10422 on 2017/5/29.
 */

public class TransactionsAdapter extends ArrayAdapter<Transactions> {
    private int resoutceId;
    public TransactionsAdapter(Context context, int textViewResourceId, List<Transactions> objects){
        super(context,textViewResourceId,objects);
        resoutceId = textViewResourceId;
    }
    @Override
    public View getView(int position , View convertView, ViewGroup parent){
        Transactions Trans=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resoutceId,null);
    /*    TextView transtitle=(TextView) view.findViewById(R.id.transactions_title);
        Button transchakan=(Button) view.findViewById(R.id.transactions_look);
        Button transshanchu=(Button) view.findViewById(R.id.transactions_del);*/
        TextView transtitle=(TextView) view.findViewById(R.id.text_title);
        ImageView trans=(ImageView) view.findViewById(R.id.imageButton);
      /*  TextView transtitle = (TextView) view.findViewById(R.id.textView2);
        ImageView transimage =(ImageView) view.findViewById(R.id.imageview);
    */    transtitle.setText(Trans.getTitle());
        return view;
    }

}
