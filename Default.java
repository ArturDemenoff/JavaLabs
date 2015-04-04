package com.main.defaultclass;

import com.labs.Parser.Parser;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Artur on 09.03.2015.
 */
public class Default {

    public static ArrayList<Parser> read(String fileName) throws FileNotFoundException {

        ArrayList<Parser> lines = new ArrayList<Parser>();

        try {
            BufferedReader in = new BufferedReader(new FileReader( fileName));
            try {
                String s;
                int i = 0;
                while ((s = in.readLine()) != null) {
                    i++;
                   // System.out.print(s + "\n" + i + " ");
                    lines.add(pars_strings((s)));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

    public  static void main(String[] args) throws ParseException, FileNotFoundException {

        ArrayList<Parser> strings = read("E:\\Учеба\\2 курс\\java\\access_log_Aug95");

        for(int i = 0; i < strings.size(); i++)
        {
            if(i == 20)
            {
                break;
            }
            System.out.print(strings.get(i).request);
        }

    }

    public static Vector<String> Parser(String line)
    {

        Vector<String> mainBufer = new Vector<String>();

        String[] bufer = line.split(" - - ");
        mainBufer.add(bufer[0]);

        System.out.print("\n");
        System.out.print(bufer[0]);

        String[] bufer1 = bufer[1].split(" \"");
        mainBufer.add(bufer1[0]);

        System.out.print("\n");
        System.out.print(bufer1[0]);

        bufer = bufer1[1].split("\" ");
        mainBufer.add(bufer[0]);

        System.out.print("\n");
        System.out.print(bufer[0]);

        bufer1 = bufer[1].split(" ");

        if(bufer1[1].contains("-"))
        {
            bufer1[1] = bufer1[1].replace('-', '0');
        }

        mainBufer.add(bufer1[0]);

        System.out.print("\n");
        System.out.print(bufer1[0]);

        mainBufer.add(bufer1[1]);

        System.out.print("\n");
        System.out.print(bufer1[1]);

        return mainBufer;
    }

    public static Parser pars_strings(String line) throws ParseException {

        Vector<String> objectLine = Parser(line);

            SimpleDateFormat sdf = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

        return new Parser(objectLine.elementAt(0), sdf.parse(objectLine.elementAt(1)),objectLine.elementAt(2), Integer.valueOf(objectLine.elementAt(3)) , Integer.valueOf(objectLine.elementAt(4)));
    }
}
