package com;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Artur on 04.04.2015.
 */
public class ElemetsOfLines {

    String Ip;
    Date Date ;
    String Request;
    int CodeAnswer;
    long NumByte;

    public ElemetsOfLines(String ip, Date date, String request, int codeAnswer, long numByte) {
        this.Ip = ip;
        this.Date = date;
        this.Request = request;
        this.CodeAnswer = codeAnswer;
        this.NumByte = numByte;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);

        return String.format(Ip + " - - " + dateFormat.format(Date) + " \"" + Request + "\" " + CodeAnswer + " " + NumByte);
    }
}
