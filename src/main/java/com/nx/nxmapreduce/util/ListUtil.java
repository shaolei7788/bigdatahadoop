package com.nx.nxmapreduce.util;

import java.util.List;

/**
 * Author： 马中华 奈学教育 https://blog.csdn.net/zhongqi2513
 **/
public class ListUtil {

    public static void main(String[] args) {

        // 请开始你的表演！！！
    }

    public static <T> void printList(List<T> list){
        for (T t : list) {
            System.out.println(t.toString());
        }
    }
}
