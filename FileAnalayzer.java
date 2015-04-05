package com;

import com.classes.LogReader;
import com.classes.LogWriter;
import com.classes.LogParser;

import java.util.Vector;

public class FileAnalayzer {

    public static void main(String[] args) throws Exception{

        LogReader reader = new LogReader();

        LogParser parser = new LogParser();

        LogWriter writer = new LogWriter();

        String filePath = args[0];//путь к файлу

        int lineFrom = Integer.valueOf(args[1]);// с какой строки считать

        int lineNumber = Integer.valueOf(args[2]);// количество строк которые нужно считать

        String outFilePath = args[3];// путь для файла записи

        String[] allLines = reader.read(filePath, lineFrom, lineNumber).split("\n");

        Vector<ElemetsOfLines> allElements = new Vector<ElemetsOfLines>();

        for(String a : allLines)
        {
            allElements.add(parser.parse(a));
        }

        writer.write(outFilePath,allElements);
    }
}
