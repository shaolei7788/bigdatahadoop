package com.nx.nxmapreduce.split;

import com.nx.nxmapreduce.common.Context;
import com.nx.nxmapreduce.task.InputSplit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Author： 马中华 奈学教育 https://blog.csdn.net/zhongqi2513
 **/
public class Spliter {

    public List<InputSplit> getSplits(Context context, String path){

        List<InputSplit> splits = null;

        if(splits == null){

            // 初始化一个容器
            splits = new ArrayList<>();
            File f = new File(path);

            if(f.isFile()){
                splits.add(new InputSplit(f.getName(), f.getPath()));
            }else{
                // 暂时不支持级联
                File[] subFiles = f.listFiles();
                for(File subFile:  subFiles){
                    splits.add(new InputSplit(subFile.getName(), subFile.getPath()));
                }
            }
        }
        return splits;
    }
}
