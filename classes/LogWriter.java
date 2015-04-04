package com.classes;

import java.util.Vector;

/**
 * Created by Artur on 04.04.2015.
 */
public class LogWriter {

    public void PrintAllElements(Vector<ElemetsOfLines> allLines)
    {
        for(ElemetsOfLines a : allLines) {
            System.out.print(a);
        }
    }


    public  void PrintElementFrom(Vector<ElemetsOfLines> allLines, int index)
    {
        for(int i = index; i < allLines.size(); i++) {
            System.out.print(allLines.get(i));
        }
    }
}
