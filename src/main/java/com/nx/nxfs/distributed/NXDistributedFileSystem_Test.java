package com.nx.nxfs.distributed;

/**
 * 测试类
 **/
public class NXDistributedFileSystem_Test {

    public static void main(String[] args) {

        FileSystem dfs = new NXDistributedFileSystem();

        // 9m    4m的大小存储每个存储快    3个数据块
        String inputFile = "c:/apache-maven-3.5.3.zip";
        String fsOutputPathDir = "/a/b";

        dfs.put(inputFile, fsOutputPathDir);
    }
}
