package com.example.a10422.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.SQLQueryListener;

public class regist_Activity extends AppCompatActivity {
    Button commit;
    Button cancel;
    EditText editregistuid;
    EditText editregistupws;
    EditText editregistupwsagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "e19106006ce90e6a56e01ee7fe565b01");
        setContentView(R.layout.activity_regist_);
        editregistuid = (EditText) findViewById(R.id.exitregistuid);
        editregistupws = (EditText) findViewById(R.id.exitregistupws);
        editregistupwsagain = (EditText) findViewById(R.id.exitregistupwsagain);
        commit = (Button) findViewById(R.id.Buttoncommit);
        cancel = (Button) findViewById(R.id.Buttoncancel);
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String stuid = editregistuid.getText().toString();
                final String stupws = editregistupws.getText().toString();
                final String stupwsa = editregistupwsagain.getText().toString();
                String bql = "select * from users where uid='" + stuid + "'";
                new BmobQuery<users>().doSQLQuery(bql, new SQLQueryListener<users>() {
                    @Override
                    public void done(BmobQueryResult<users> bmobQueryResult, BmobException e) {
                        if (e == null) {
                            if (stupws.equals(stupwsa)) {
                                users u2 = new users();
                                u2.setUid(stuid);
                                u2.setUpasswords(stupws);
                                u2.save(new SaveListener<String>() {
                                    @Override
                                    public void done(String s, BmobException e) {
                                        if (e == null) {
                                            Toast.makeText(regist_Activity.this, "注册成功，返回objectid为：" + s, Toast.LENGTH_SHORT).show();
                                            Intent intent =new Intent(regist_Activity.this,MainActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(regist_Activity.this, "注册失败：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                            // Log.i("e.getMessage()",e.getMessage());
                                            //System.out.println(e.getMessage());
                                        }
                                    }
                                });
                            }
                        } else {
                            Toast.makeText(regist_Activity.this, "这个用户名已经被用过了，请换一个id" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    ;

                });
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(regist_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
