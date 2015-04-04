package com.interfaces;

import java.text.ParseException;

/**
 * Created by Artur on 04.04.2015.
 */
public interface ILogParser<T> {
    T parse(String line) throws ParseException;
}
