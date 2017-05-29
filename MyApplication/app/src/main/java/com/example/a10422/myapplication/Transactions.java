package com.example.a10422.myapplication;

/**
 * Created by 10422 on 2017/5/29.
 */

public class Transactions {
    protected String  title;
    protected String starttime;
    protected  String endtime;
    protected  String text;
    public Transactions(String title,String starttime ,String endtime,String text){
        this.title=title;
        this.text=text;
        this.endtime=endtime;
        this.starttime=starttime;
    }
    public String getTitle(){
        return title;
    }
    public String getStarttime(){
        return starttime;
    }
    public String getEndtime(){
        return endtime;
    }
    public String getText(){
        return text;
    }
}
