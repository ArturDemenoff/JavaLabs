package com.classes;

import com.ElemetsOfLines;
import com.ReportMaxAnswer;
import com.ReportSumAnswers;
import com.interfaces.ISumAnswers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Created by Artur on 05.04.2015.
 */
public class SumAnswers implements ISumAnswers {

    @Override
    public ReportSumAnswers SumOfAnswers(Vector<ElemetsOfLines> outLines, Date fromDate, Date toDate, SimpleDateFormat dateFormat) {
        int sum = 0;

        for(ElemetsOfLines element: outLines)
        {
            if(element.Date.after(fromDate) && element.Date.before(toDate))
            {
                sum+=element.NumByte;
            }
        }

        ReportSumAnswers report = new ReportSumAnswers();
        report.sum = sum;
        return report;
    }
}
