package com;

import com.classes.*;
import com.interfaces.ILogParser;
import com.interfaces.ILogWriter;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileAnalayzer {

    public static void main(String[] args) throws Exception{


        String filePath = args[0];//путь к файлу

        int lineFrom = Integer.valueOf(args[1]);// с какой строки считать

        int lineNumber = Integer.valueOf(args[2]);// количество строк которые нужно считать

        String outFilePath = args[3];// путь для файла записи
        ILogParser<ElemetsOfLines> parser = new LogParser();
        ILogWriter<Vector<ElemetsOfLines>> writer = new LogWriter();


        LogReader record = new LogReader();

        Vector<String> lines = record.read(filePath, lineFrom, lineNumber);


        Vector<ElemetsOfLines> outLines = new Vector<ElemetsOfLines>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd:HH:mm:ss");

        System.out.println("Input from date in format (yyyy.MM.dd:HH:mm:ss): ");

        Scanner scanner = new Scanner(System.in);

        String date = scanner.next();
        Date fromDate = dateFormat.parse(date);

        System.out.println("Input to date in format (yyyy.MM.dd:HH:mm:ss): ");
        date = scanner.next();
        Date toDate =  dateFormat.parse(date);

        for(String line : lines)
        {
            outLines.add(parser.parse(line));
        }

        writer.write(outFilePath, outLines);

        int numofreport = Integer.valueOf(args[4]);

        if(numofreport == 1)
        {
            MaxAnswer report = new MaxAnswer();
            ReportMaxAnswer maxAnswer = report.GetMaxAnswer(outLines,fromDate,toDate);

            System.out.print(maxAnswer.max);
        }
        if(numofreport == 2)
        {
            SumAnswers report = new SumAnswers();
            ReportSumAnswers sumAnswers = report.SumOfAnswers(outLines,fromDate,toDate,dateFormat);
            System.out.print(sumAnswers.sum);
        }
        if(numofreport == 3)
        {
            MaxAnswer report = new MaxAnswer();

            System.out.print(report.GetMaxAnswer(outLines,fromDate,toDate));
        }
    }
}
