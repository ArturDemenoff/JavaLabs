package com.interfaces;

/**
 * Created by Artur on 04.04.2015.
 */
public interface ILogReader
{
    String read(String fileName, int line, int numLine) throws Exception;
}