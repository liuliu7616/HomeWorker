package com.example.a10422.myapplication;

import android.support.v7.app.AppCompatActivity;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View.OnClickListener;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class homeActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton buttonadd;
    transactionAdapter adapter;
    String uid;
    int position;
    private List<transaction> TransList = new ArrayList<transaction>();

    public void onResume(){
        super.onResume();
        TransList.clear();
        initTrans();

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"e19106006ce90e6a56e01ee7fe565b01");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Bundle bundle=getIntent().getExtras();
        uid=bundle.getString("userid");
      //  initTrans();
        adapter = new transactionAdapter(homeActivity.this,R.layout.transactions_item1,TransList);
        setContentView(R.layout.home_activity);
        buttonadd = (ImageButton) findViewById(R.id.add);
        buttonadd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(homeActivity.this,addActivity.class);
                intent.putExtra("userid",uid);
                startActivity(intent);
            }
        });
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int positon,long id){
                Intent it=new Intent();
                position=positon;
                it.setClass(homeActivity.this,Transactions_Activity.class);
                it.putExtra("userid",uid);
                it.putExtra("positon",position);
                startActivity(it);
            }
        });
    }
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.add:{
                Intent intent =new Intent(homeActivity.this,addActivity.class);
                intent.putExtra("userid",uid);
                startActivity(intent);
            }
        }
    }
    private void initTrans(){
       BmobQuery<transaction> query =new BmobQuery<transaction>();
        query.order("-updatedAt");
        query.addWhereEqualTo("uid",uid);
        query.setLimit(50);
        query.findObjects(new FindListener<transaction>(){
           // public void done(List<transaction> list,BmobException e){}
            @Override
            public void done(List<transaction> list,BmobException e){
                if(e==null){
                    if(list!=null && list.size()>0){
                        TransList.addAll(list);
                        adapter.notifyDataSetChanged();
                    }
                }
                else{
                    Toast.makeText(homeActivity.this,"not",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
