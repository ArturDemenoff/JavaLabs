package com.interfaces;

import com.ElemetsOfLines;

import java.util.Date;
import java.util.Vector;

/**
 * Created by Artur on 23.05.2015.
 */
public interface IMostActive {
    String[] mostActive(Vector<ElemetsOfLines> outLines, Date fromDate, Date toDate);
}
