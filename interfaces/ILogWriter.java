package com.interfaces;

import com.ElemetsOfLines;

import java.io.IOException;
import java.util.Vector;

/**
 * Created by Artur on 04.04.2015.
 */
public interface ILogWriter <T>
{
    void write(String FileName, T lines) throws IOException;
}
