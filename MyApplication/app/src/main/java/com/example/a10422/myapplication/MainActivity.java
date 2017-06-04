package com.example.a10422.myapplication;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.socketio.callback.StringCallback;

public class MainActivity extends AppCompatActivity {
    Button buttonlogin;
    Button buttonregist;
    EditText edituid;
    EditText editupws;
    String struid;
    String strupws;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"e19106006ce90e6a56e01ee7fe565b01");
        setContentView(R.layout.login1);
        edituid=(EditText) findViewById(R.id.exituid);
        editupws=(EditText)findViewById(R.id.exitupws);
        buttonlogin =(Button) findViewById(R.id.Buttonlogin);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 struid=edituid.getText().toString();
                strupws=editupws.getText().toString();

                BmobQuery<users> query=new BmobQuery<users>();
                query.addWhereEqualTo("uid",struid);
                query.findObjects(new FindListener<users>() {
                    @Override
                    public void done(List<users> list, BmobException e) {
                        if (e==null&&list.get(0).getUpasswords().equals(strupws)) {
                            Toast.makeText(MainActivity.this,"login succeed",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(MainActivity.this,homeActivity.class);
                            intent.putExtra("userid",struid);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this,"用户名和密码不符",Toast.LENGTH_SHORT).show();                        }
                    }
                });

            }
        });
        buttonregist=(Button) findViewById(R.id.Buttonregist);
        buttonregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,regist_Activity.class);
                startActivity(intent);
            }
        });
    }
}
