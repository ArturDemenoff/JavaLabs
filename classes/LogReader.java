package com.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Artur on 04.04.2015.
 */
public class LogReader {

    public String Read(String fileName, int formLine, int lineNumber) throws IOException, ParseException {

        StringBuilder sb = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        int i = 0;
        int j = 0;

        String currentLine;

        while((currentLine = reader.readLine() )!= null)
        {
            if(i == formLine - 1)
            {
                sb.append(currentLine + "\n");
                while((currentLine = reader.readLine() )!= null && j != lineNumber - 1)
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
