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
