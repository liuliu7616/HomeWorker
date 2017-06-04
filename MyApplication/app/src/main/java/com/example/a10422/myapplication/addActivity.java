package com.example.a10422.myapplication;

import android.content.Intent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class addActivity extends AppCompatActivity {
    Button buttonsave;
    EditText edittitle;
    EditText editstarttime;
    EditText editendtime;
    EditText edittext;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"e19106006ce90e6a56e01ee7fe565b01");
        setContentView(R.layout.add_activity);
        Bundle bundle=getIntent().getExtras();
        uid=bundle.getString("userid");
        edittitle = (EditText) findViewById(R.id.edit_title);
        editstarttime = (EditText) findViewById(R.id.edit_starttime);
        editendtime = (EditText) findViewById(R.id.edit_endtime);
        edittext = (EditText) findViewById(R.id.edit_text);
        buttonsave = (Button) findViewById(R.id.buttonsave);
        buttonsave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String trantitle = edittitle.getText().toString();
           //     DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
            /*    try {
                    final Date transtarttime = df.parse(editstarttime.getText().toString());
                }catch(Exception e){}*/
                final String transtarttime=editstarttime.getText().toString();
                final String tranendtime = editendtime.getText().toString();
                final String trantext= edittext.getText().toString();
                transaction trantem = new transaction();
                trantem.setStarttime(transtarttime);
                trantem.setTitle(trantitle);
                trantem.setEndtime(tranendtime);
                trantem.setDoing(trantext);
                trantem.setUid(uid);
                trantem.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if(e==null){
                            Toast.makeText(addActivity.this, "tianjia成功，返回objectid为：" + s, Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(addActivity.this,homeActivity.class);
                            intent.putExtra("userid",uid);
                            this.onFinish();
                            startActivity(intent);

                        }
                        else {
                            Toast.makeText(addActivity.this, "tianjia失败：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            // Log.i("e.getMessage()",e.getMessage());
                            //System.out.println(e.getMessage());
                        }
                    }
                });
            }
        });



    }

}
