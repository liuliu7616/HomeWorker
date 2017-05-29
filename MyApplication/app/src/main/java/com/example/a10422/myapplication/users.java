package com.example.a10422.myapplication;

import cn.bmob.v3.BmobObject;

/**
 * Created by 10422 on 2017/5/27.
 */

public class users extends BmobObject {
    private String uid;
    private String upasswords;

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getUpasswords() {
        return upasswords;
    }
    public void setUpasswords(String upasswords) {
        this.upasswords= upasswords;
    }

}
