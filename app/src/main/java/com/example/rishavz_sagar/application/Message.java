package com.example.rishavz_sagar.application;

/**
 * Created by rishavz_sagar on 15-May-16.
 */
public class Message {
    private String message,others;
    int type;
    public Message(String message,String others,int type)
    {
        this.message=message;
        this.others=others;
        this.type=type;
    }

    public String getMessage() {
        return message;
    }


    public String getOthers() {
        return others;
    }

    public int getType() {
        return type;
    }

}
