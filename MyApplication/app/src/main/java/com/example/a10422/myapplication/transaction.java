package com.example.a10422.myapplication;

import cn.bmob.v3.BmobObject;

/**
 * Created by 10422 on 2017/5/30.
 */

public class transaction extends BmobObject {
    private String uid;
    private String starttime;
    private  String endtime;
    private String doing;

    public String getDoing() {
        return doing;
    }

    public void setDoing(String doing) {
        this.doing = doing;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }
}
