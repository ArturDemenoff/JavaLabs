package com.classes;

import com.ElemetsOfLines;
import com.interfaces.IMostActive;

import java.util.*;

/**
 * Created by Artur on 23.05.2015.
 */
public class MostActive implements IMostActive {

    @Override
    public String[] mostActive(Vector<ElemetsOfLines> outLines, Date fromDate, Date toDate) {

        Map<String , Integer> activeMap = new HashMap<>();
        String[] active = new String[5];



        for(ElemetsOfLines element: outLines )
        {
            if(element.Date.after(fromDate) && element.Date.before(toDate)) {
                if (activeMap.containsKey(element.Adress)) {
                    activeMap.put(element.GetStringOfAdress(), (activeMap.get(element.Adress) + 1));
                } else {
                    activeMap.put(element.GetStringOfAdress(), 0);
                }
            }
        }

        List<Map.Entry<String , Integer>> list = new ArrayList(activeMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String , Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue().compareTo(b.getValue());
            }
        });

        Integer i = 0;
        for(Map.Entry<String, Integer> element : list)
        {
            if(i == 6)
            {
                break;
            }

            active[i] = element.getKey();
        }


        return active;
    }
}
