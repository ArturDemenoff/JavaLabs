package com;

import com.classes.ElemetsOfLines;
import com.classes.LogParser;
import com.classes.LogReader;
import com.classes.LogWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class FileAnalayzer {

    public static void main(String[] args) throws Exception{

        LogReader reader = new LogReader();

        LogParser parser = new LogParser();

        LogWriter writer = new LogWriter();

        String filePath = args[0];//путь к файлу

        int lineFrom = Integer.valueOf(args[1]);// с какой строки считать

        int lineNumber = Integer.valueOf(args[2]);// количество строк которые нужно считать

        String[] allLines = reader.Read(filePath, lineFrom, lineNumber).split("\n");

        Vector<ElemetsOfLines> allElements = new Vector<ElemetsOfLines>();

        for(String a : allLines)
        {
            allElements.add(parser.IntoElements(a));
        }

        writer.PrintAllElements(allElements);
    }
}
