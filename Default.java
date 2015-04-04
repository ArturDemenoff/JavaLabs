package com.main.defaultclass;

import com.labs.Parser.Parser;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Artur on 09.03.2015.
 */
public class Default {

    public static ArrayList<Parser> read(String fileName, int begin, int count) throws IOException, ParseException {

        ArrayList<Parser> lines = new ArrayList<Parser>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        int i = 0;
        int j = 0;

        String currentLine;

       // Vector<String> lines = new Vector<String>();

        while((currentLine = reader.readLine() )!= null)
        {
            if(i == begin - 1)
            {
                lines.add(pars_strings(currentLine));
                while((currentLine = reader.readLine() )!= null && j != count - 1)
                {
                    lines.add(pars_strings(currentLine));
                    j++;
                }

                break;
            }
            i++;
        }

        reader.close();

        return lines;
    }

    public  static void main(String[] args) throws ParseException, IOException {



        String filePath = args[0];//путь к файлу

        int begin = Integer.valueOf(args[1]);// с какой строки считать

        int count = Integer.valueOf(args[2]);// количество строк которые нужно считать

        ArrayList<Parser> strings = read(filePath,begin,count);

    }

    public static Vector<String> Parser(String line)
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

    public static Parser pars_strings(String line) throws ParseException {

        Vector<String> objectLine = Parser(line);

            SimpleDateFormat sdf = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

        return new Parser(objectLine.elementAt(0), sdf.parse(objectLine.elementAt(1)),objectLine.elementAt(2), Integer.valueOf(objectLine.elementAt(3)) , Integer.valueOf(objectLine.elementAt(4)));
    }
}
