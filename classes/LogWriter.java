package com.classes;

import com.ElemetsOfLines;
import com.interfaces.ILogWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Artur on 04.04.2015.
 */
public class LogWriter implements ILogWriter<Vector<ElemetsOfLines>> {

    @Override
    public void write(String FileName, Vector<ElemetsOfLines> lines) throws IOException {


        BufferedWriter wrt = new BufferedWriter(new FileWriter(FileName));

        for(ElemetsOfLines line : lines)
        {
            wrt.write(line.toString());
            wrt.newLine();
        }

        wrt.close();
    }
}
