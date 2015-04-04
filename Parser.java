package com.labs.Parser;

import java.util.Date;

/**
 * Created by Artur on 09.03.2015.
 */
public class Parser {
    public Date data ;
    public String ip;
    public String request;
    public int reply;
    public long bytes;

    public Parser(String ip, Date data, String request, int reply, long bytes)
    {
        this.data = data;
        this.ip = ip;
        this.request = request;
        this.reply = reply;
        this.bytes = bytes;
    }
}
