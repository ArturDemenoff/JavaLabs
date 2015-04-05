package com.classes;

import com.ElemetsOfLines;
import com.ReportMaxAnswer;
import com.interfaces.IMaxAnswer;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 * Created by Artur on 05.04.2015.
 */
public class MaxAnswer implements IMaxAnswer {

    @Override
    public ReportMaxAnswer GetMaxAnswer(Vector<ElemetsOfLines> outLines, Date fromDate, Date toDate, SimpleDateFormat dateFormat) {
        int max = 0;

        for(ElemetsOfLines element: outLines)
        {
            if(element.Date.after(fromDate) && element.Date.before(toDate))
            {
                if(element.NumByte > max)
                {
                    max = (int)element.NumByte;
                }
            }
        }

        ReportMaxAnswer report = new ReportMaxAnswer();
        report.max = max;

        return report;
    }
}
