package com;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

/**
 * Created by Artur on 04.04.2015.
 */
public class ElemetsOfLines {


    public Vector<Integer>  IP;
    public Vector<String> Adress;
    public Date Date ;
    public String Request;
    public int CodeAnswer;
    public long NumByte;

    public ElemetsOfLines(Vector<String> adress,Vector<Integer> ip, Date date, String request, int codeAnswer, long numByte) {
        this.Adress = adress;
        this.IP = ip;
        this.Date = date;
        this.Request = request;
        this.CodeAnswer = codeAnswer;
        this.NumByte = numByte;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);

        return String.format(GetStringOfIp() + " - - " + dateFormat.format(Date) + " \"" + Request + "\" " + CodeAnswer + " " + NumByte);
    }

    private String GetStringOfIp()
    {
        StringBuilder sb = new StringBuilder();

        if(IP.size() != 0){
            for (int i = 0; i < IP.size(); i++) {
                sb.append(IP.get(i).toString() + ".");
            }
        }
        else {
            for(String s : Adress)
            {
                sb.append(s + ".");
            }

        }

        return sb.toString();
    }
}
