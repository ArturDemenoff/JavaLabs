package com.interfaces;

import java.util.Vector;

/**
 * Created by Artur on 04.04.2015.
 */
public interface ILogReader
{
    Vector<String> read(String fileName, int line, int numLine) throws Exception;
}