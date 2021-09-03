package com.nx.nxmapreduce.task;

import com.nx.nxmapreduce.common.Context;
import com.nx.nxmapreduce.inputformat.ReducerInputFormat;
import com.nx.nxmapreduce.outputformat.ReducerOutputFormat;
import com.nx.nxmapreduce.reducer.Reducer;
import com.nx.nxmapreduce.util.PathUtil;

import java.io.*;

/**
 * Author： 马中华 奈学教育 https://blog.csdn.net/zhongqi2513
 **/
public class ReduceTask {

    private int reduceTaskID_index;
    private String jobID;

    public ReduceTask(String jobID, int i) {
        this.reduceTaskID_index = i;
        this.jobID = jobID;
    }

    public void runReduceTask(Context context, int reduceTaskID_index) {

        ReducerInputFormat reducerInputFormat = null;
        ReducerOutputFormat reducerOutputFormat = null;
        Reducer reducer = null;
        try {
            reducer = context.getReducer().newInstance();

            // 用来合并的组件
            reducerInputFormat = context.getReducerInputFormat().newInstance();

            // 用来输出的组件
            reducerOutputFormat = context.getReducerOutputFormat().newInstance();

            // 获取结果输出文件完成路径
            String outFile = initLastOutputFile(context, reduceTaskID_index);

            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter(new FileOutputStream(new File(outFile)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            reducerOutputFormat.setPrintWriter(printWriter);

            // 获取分区合并之后的结果文件

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 合并文件
        System.out.println("开始合并");
        String reduceTempFile = reducerInputFormat.mergeMapTempFiles(context, reduceTaskID_index);

        // 初始化reduceTask读取合并后磁盘文件的输入流
        try {
            reducerOutputFormat.setReader(new BufferedReader(new FileReader(new File(reduceTempFile))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * 调用业务逻辑
         */
        reducer.run(reducerOutputFormat, reduceTempFile);
    }

    private String initLastOutputFile(Context context, int reduceTaskID_index) {
        String outputDir = context.getOutputDir();
        return outputDir + "/" + PathUtil.generateReduceOutputTempFileName(reduceTaskID_index);
    }
}
