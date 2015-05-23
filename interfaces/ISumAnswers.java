package com.interfaces;

import com.ElemetsOfLines;
import com.ReportSumAnswers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Created by Artur on 05.04.2015.
 */
public interface ISumAnswers {

    public ReportSumAnswers SumOfAnswers(Vector<ElemetsOfLines> outLines, Date fromDate, Date toDate, SimpleDateFormat dateFormat);

}
/*2012.02.05:15:12:13
        2012.05.05:15:12:13*/