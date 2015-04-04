package com.classes;
import com.ElemetsOfLines;
import com.interfaces.ILogParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Vector;

/**
 * Created by Artur on 04.04.2015.
 */
public class LogParser implements ILogParser<ElemetsOfLines> {

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

    @Override
    public ElemetsOfLines parse(String line) throws ParseException {
        Vector<String> objectLine = Parser(line);

        SimpleDateFormat sdf = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);

        return new ElemetsOfLines(objectLine.elementAt(0), sdf.parse(objectLine.elementAt(1)),objectLine.elementAt(2), Integer.valueOf(objectLine.elementAt(3)) , Integer.valueOf(objectLine.elementAt(4)));
    }
}
