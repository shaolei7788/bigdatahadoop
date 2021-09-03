package com.nx.nxmapreduce.sort;

import com.nx.nxmapreduce.task.Record;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author： 马中华 奈学教育 https://blog.csdn.net/zhongqi2513
 **/
public class Sort {

    public void sort(List<Record> records){

        Collections.sort(records, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return (int)o1.getKey().compareTo(o2.getKey());
            }
        });
    }
}
