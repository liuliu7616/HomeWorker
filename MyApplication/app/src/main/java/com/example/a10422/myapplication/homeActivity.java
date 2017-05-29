package com.example.a10422.myapplication;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.socketio.callback.StringCallback;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class homeActivity extends AppCompatActivity implements View.OnClickListener {
    //ImageButton Imagebuttonadd;
    private List<Transactions> TransList = new ArrayList<Transactions>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"e19106006ce90e6a56e01ee7fe565b01");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_activity);
        initTrans();
       TransactionsAdapter adapter = new TransactionsAdapter(homeActivity.this,R.layout.transactions_item1,TransList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int positon,long id){
                Intent it=new Intent();
                switch (positon){
                    case 0:
                        it.setClass(homeActivity.this,Transactions_Activity.class);
                        break;
                    case 1:
                        it.setClass(homeActivity.this,Transactions_Activity.class);
                        break;
                    case 2:
                        it.setClass(homeActivity.this,Transactions_Activity.class);
                        break;
                    default:
                        break;
                }
                startActivity(it);
            }
        });
       // Imagebuttonadd =(ImageButton) findViewById(R.id.ImageButtonadd);
      //  Imagebuttonadd.setOnClickListener(this);
    }
    public void onItemClick(AdapterView<TransactionsAdapter> parent,View view,int positon,long id){
        Intent it=new Intent();
        switch (positon){
            case 0:
                it.setClass(homeActivity.this,Transactions_Activity.class);
                break;
            case 2:
                it.setClass(homeActivity.this,Transactions_Activity.class);
                break;
            case 3:
                it.setClass(homeActivity.this,Transactions_Activity.class);
                break;
            default:
                break;
        }
        startActivity(it);
    }
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.ImageButtonadd:{
                Intent intent =new Intent(homeActivity.this,addActivity.class);
                startActivity(intent);
            }
        }
    }
    private void initTrans(){
     /*   BmobQuery<transaction> query =new BmobQuery<transaction>();
        query.addWhereEqualTo("uid","hello");
        query.setLimit(50);
        query.findObjects(this , new FindListener<transaction>(){
            public void done(List<transaction> list,BmobException e){}
            @Override
            public void onSucccess(List<transaction> object){

                Toast.makeText(homeActivity.this,"query succeed",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(int code,String msg){
               Toast.makeText(homeActivity.this,"查询失败："+msg,Toast.LENGTH_SHORT).show();
            }
        });*/
        Transactions t1=new Transactions("title1 this is the imagebutton test ","10-01","10-2","test1");
        TransList.add(t1);
        Transactions t2=new Transactions("title2","10-01","10-2","test2");
        TransList.add(t2);
        Transactions t3=new Transactions("title3","10-01","10-2","test3");
        TransList.add(t3);
        Transactions t4=new Transactions("title4","10-01","10-2","test4");
        TransList.add(t4);
        Transactions t5=new Transactions("title5","10-01","10-2","test5");
        TransList.add(t5);
        Transactions t6=new Transactions("title6","10-01","10-2","test6");
        TransList.add(t6);
        Transactions t8=new Transactions("title6","10-01","10-2","test6");
        TransList.add(t8);
        Transactions t9=new Transactions("title6","10-01","10-2","test6");
        TransList.add(t9);
        Transactions t10=new Transactions("title6","10-01","10-2","test6");
        TransList.add(t10);
        Transactions t11=new Transactions("title6","10-01","10-2","test6");
        TransList.add(t11);
        Transactions t12=new Transactions("title6","10-01","10-2","test6");
        TransList.add(t12);
        Transactions t13=new Transactions("title6","10-01","10-2","test6");
        TransList.add(t13);
        Transactions t14=new Transactions("title6","10-01","10-2","test6");
        TransList.add(t14);

    }/*
    private final class ItemClickEvent implements OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<TransactionsAdapter> parent,View view,int positon,long id){
            Intent it=new Intent();
            switch (positon){
                case 0:
                    it.setClass(homeActivity.this,Transactions_Activity.class);
                    break;
                case 2:
                    it.setClass(homeActivity.this,Transactions_Activity.class);
                    break;
                case 3:
                    it.setClass(homeActivity.this,Transactions_Activity.class);
                    break;
                default:
                    break;
            }
            startActivity(it);
        }
    }*/


}
