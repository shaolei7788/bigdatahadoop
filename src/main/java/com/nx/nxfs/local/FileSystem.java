package com.nx.nxfs.local;

import java.util.List;

/**
 * 本地简易文件系统实现
 **/
public interface FileSystem {

    // 我的文件系统的数据存储在windos系统的根目录
    String rootDir = "C:/bigdata-nxfs";

    // 上传文件 到指定目录
    void put(String inputFile, String outputDir);

    // 下载文件 到指定文件夹
    void get(String inputFile, String outputDir);

    void mkdir(String mkdir);

    // 展示某个文件夹的所有子内容
    List<String> list(String inputPath);
}
