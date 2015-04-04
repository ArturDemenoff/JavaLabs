package com.classes;

import com.interfaces.ILogReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Artur on 04.04.2015.
 */
public class LogReader implements ILogReader {


    @Override
    public String read(String fileName, int line, int numLine) throws Exception {

        StringBuilder sb = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        int i = 0;
        int j = 0;

        String currentLine;

        while((currentLine = reader.readLine() )!= null)
        {
            if(i == line - 1)
            {
                sb.append(currentLine + "\n");
                while((currentLine = reader.readLine() )!= null && j != numLine - 1)
                {
                    sb.append(currentLine);
                    sb.append("\n");
                }

                break;
            }
            i++;
        }

        reader.close();

        return sb.toString();
    }
}
