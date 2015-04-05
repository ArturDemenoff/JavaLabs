package com.interfaces;

import com.ReportMaxAnswer;
import com.ElemetsOfLines;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 * Created by Artur on 05.04.2015.
 */
public interface IMaxAnswer {
    ReportMaxAnswer GetMaxAnswer(Vector<ElemetsOfLines> outLines, Date fromDate, Date toDate, SimpleDateFormat dateFormat);
}
