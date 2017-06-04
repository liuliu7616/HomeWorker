package com.example.a10422.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class Transactions_Activity extends AppCompatActivity {
    Button buttonsave;
    Button buttondelete;
    EditText edittile;
    EditText editstarttime;
    EditText editendtime;
    EditText edittext;
    String uid;
    int position;
    String itemid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"e19106006ce90e6a56e01ee7fe565b01");
        setContentView(R.layout.activity_transactions);
        Bundle bundle=getIntent().getExtras();
        uid=bundle.getString("userid");
         Bundle bundle1=getIntent().getExtras();
        position=bundle1.getInt("positon");
        edittile = (EditText) findViewById(R.id.edit_title);
        editendtime = (EditText) findViewById(R.id.edit_endtime);
        editstarttime = (EditText) findViewById(R.id.edit_starttime);
        edittext = (EditText) findViewById(R.id.edit_text);

        BmobQuery<transaction> query =new BmobQuery<transaction>();
        query.order("-updatedAt");
        query.addWhereEqualTo("uid",uid);
        query.setLimit(50);
        query.findObjects(new FindListener<transaction>(){
            @Override
            public void done(List<transaction> list, BmobException e){
                if(e==null){
                    if(list!=null && list.size()>0){

                       edittext.setText(list.get(position).getDoing().toString());
                        editstarttime.setText(list.get(position).getEndtime().toString());
                        editendtime.setText(list.get(position).getStarttime().toString());
                        edittile.setText(list.get(position).getTitle().toString());
                        itemid=list.get(position).getObjectId();
                    }
                }
                else{
                    Toast.makeText(Transactions_Activity.this,"not",Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttondelete = (Button) findViewById(R.id.buttondelete);
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction trans =new transaction();
                trans.setObjectId(itemid);
                trans.delete(new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e==null){
                            Toast.makeText(Transactions_Activity.this,"delete succeed",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Transactions_Activity.this,homeActivity.class);
                            intent.putExtra("userid",uid);
                            this.onFinish();
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(Transactions_Activity.this,"delete fail",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        buttonsave = (Button) findViewById(R.id.buttonsave);
        buttonsave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String trantitle =edittile.getText().toString();
                final String transtarttime=editstarttime.getText().toString();
                final String tranendtime = editendtime.getText().toString();
                final String trantext= edittext.getText().toString();
                transaction trantem = new transaction();
                trantem.setStarttime(transtarttime);
                trantem.setTitle(trantitle);
                trantem.setEndtime(tranendtime);
                trantem.setDoing(trantext);
                trantem.setUid(uid);
                trantem.update(itemid, new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e==null){
                            Toast.makeText(Transactions_Activity.this,"update succeed",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Transactions_Activity.this,homeActivity.class);
                            intent.putExtra("userid",uid);
                            startActivity(intent);
                            this.onFinish();
                        }else {
                            Toast.makeText(Transactions_Activity.this,"update fail",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
