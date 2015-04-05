package com.classes;
import com.ElemetsOfLines;
import com.interfaces.ILogParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Artur on 04.04.2015.
 */
public class LogParser implements ILogParser<ElemetsOfLines> {

    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";



    Vector<String> Parser(String line)
    {

        Vector<String> mainBufer = new Vector<String>();

        String[] bufer = line.split(" - - ");
        mainBufer.add(bufer[0]);
        String[] bufer1 = bufer[1].split(" \"");
        mainBufer.add(bufer1[0]);
        bufer = bufer1[1].split("\" ");
        mainBufer.add(bufer[0]);
        bufer1 = bufer[1].split(" ");
        mainBufer.add(bufer1[0]);
        mainBufer.add(bufer1[1]);

        return mainBufer;
    }

    private boolean isvalid(String IP)
    {
        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(IP);
        return matcher.matches();
    }

    private Vector<String> ParseAddress(String IP)
    {
        Vector<String> IPAddress = new Vector<String>();

        for(String num: IP.split("\\."))
        {
            IPAddress.add(num);
        }
        return IPAddress;
    }

    @Override
    public ElemetsOfLines parse(String line) throws ParseException {
        Vector<String> objectLine = Parser(line);

        Vector<Integer> IP = new Vector<Integer>();

        Vector<String> Adress = ParseAddress(objectLine.elementAt(0));

        if(isvalid(objectLine.elementAt(0))) {
                for(String num : Adress)
                {
                    IP.add(Integer.valueOf(num));
                }
            }

        SimpleDateFormat sdf = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);

        return new ElemetsOfLines(Adress ,IP, sdf.parse(objectLine.elementAt(1)),objectLine.elementAt(2), Integer.valueOf(objectLine.elementAt(3)) , Integer.valueOf(objectLine.elementAt(4)));
    }
}
