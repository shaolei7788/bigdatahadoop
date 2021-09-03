package com.nx.nxmapreduce.task;

import com.nx.nxmapreduce.common.Context;
import com.nx.nxmapreduce.inputformat.MapInputFormat;
import com.nx.nxmapreduce.mapper.Mapper;
import com.nx.nxmapreduce.outputformat.MapOutputFormat;

/**
 * Author： 马中华 奈学教育 https://blog.csdn.net/zhongqi2513
 **/
public class MapTask {

    public void runMapTask(InputSplit split, Context context) {

        // 生成一个TaskID
        String taskID = initTaskID(split, context);

        /**
         * 初始化Mapper的输入
         */
        MapInputFormat mapInputFormat = new MapInputFormat(split.getBlockPath());

        /**
         * 运行Task,把结果输出到临时目录
         */
        String tempOutputPath = context.getConf("nxmapreduce_temp");
        // 会按照分区的个数，生成对应数量的输出流
        MapOutputFormat mapOutputFormat = new MapOutputFormat(tempOutputPath, context, taskID);

        // 运行mapTask，注意每个MapTask都应该是一个独立的。
        Mapper mapper = null;
        try {
            // 通过反射，构建map实例
            mapper = context.getMapper().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // 运行 map 的 run 方法
        mapper.run(mapInputFormat, mapOutputFormat);
    }

    private String initTaskID(InputSplit split, Context context) {
        return "nxmr_map_task_" + split.getBlockId();
    }
}
