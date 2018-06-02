package com.yaya.simplechatapp;

/**
 * Created by Administrator on 2018/5/12.
 * 功能：
 */
public class MsgChatBody {
    public int type;//消息类型
    public String msg;//消息内容

    public MsgChatBody(String msg, int type) {
        this.type = type;
        this.msg = msg;
    }
}
