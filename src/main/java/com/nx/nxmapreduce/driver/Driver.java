package com.nx.nxmapreduce.driver;


import com.nx.nxmapreduce.common.Context;
import com.nx.nxmapreduce.inputformat.MapInputFormat;
import com.nx.nxmapreduce.inputformat.ReducerInputFormat;
import com.nx.nxmapreduce.job.Job;
import com.nx.nxmapreduce.mapper.Mapper;
import com.nx.nxmapreduce.outputformat.MapOutputFormat;
import com.nx.nxmapreduce.outputformat.ReducerOutputFormat;
import com.nx.nxmapreduce.partitioner.Partitioner;
import com.nx.nxmapreduce.reducer.Reducer;
import com.nx.nxmapreduce.sort.Sort;

/**
 * Author： 马中华 奈学教育 https://blog.csdn.net/zhongqi2513
 *
 * 是使用多线程的方式来模拟实现的。
 * 不是多进程
 * 一个线程执行一个Task
 **/
public class Driver {

    public static void main(String[] args) {

        // 请开始你的表演！！！
        Context context = new Context();

        Job job = new Job(context);

        // MapInputFormat 负责给mapper阶段读取数据
        job.setMapInputFormat(MapInputFormat.class);
        // 负责第一阶段的逻辑处理的
        job.setMapper(Mapper.class);
        // MapOutputFormat 负责给第一个阶段输出结果的
        job.setMapOutputFormat(MapOutputFormat.class);

        // Partitioner 制定分区规则
        job.setPartitioner(Partitioner.class);
        job.setNumPartitions(3);
        // Sort 制定排序规则
        job.setSort(Sort.class);

        // 负责给 Reducer 读取数据的
        job.setReducerInputFormat(ReducerInputFormat.class);
        // Reducer 第二个阶段业务逻辑处理
        // 负责给reducer写出数据的
        job.setReducer(Reducer.class);
        job.setReducerOutputFormat(ReducerOutputFormat.class);

        // 指定真个应用程序的输入和输出
        job.setInputPath("C:\\bigdata-nxmapreduce\\input");
        job.setOutputPath("C:\\bigdata-nxmapreduce\\output");

        // 提交任务
        job.submit();

        System.exit(0);
    }
}
