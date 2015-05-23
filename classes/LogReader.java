package com.classes;

import com.interfaces.ILogReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

/**
 * Created by Artur on 04.04.2015.
 */
public class LogReader implements ILogReader {


    @Override
    public Vector<String> read(String fileName, int line, int numLine) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        Vector<String> lines = new Vector<String>();

        int i = 0;
        int j = 0;

        String currentLine;

        while((currentLine = reader.readLine() )!= null)
        {
            if(i == line - 1)
            {
                lines.add(currentLine);
                while((currentLine = reader.readLine() )!= null && j != numLine - 1)
                {
                    lines.add(currentLine);
                    j++;
                }

                break;
            }
            i++;
        }

        reader.close();

        return lines;
    }
}
