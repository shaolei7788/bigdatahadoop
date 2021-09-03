package com.nx.nxfs.local;

import com.nx.nxfs.local.NXLocalFileSystem;

import java.util.List;

/**
 * 模拟单机实现： 我们找一个 windows 文件系统的某个地方, 作为的我们自己的文件系统的跟陆金
 **/
public class NXLocalFileSystem_Test {

    public static void main(String[] args) {

        NXLocalFileSystem fs = new NXLocalFileSystem();

        // 输入路径是 localFileSystem 的绝对路径
        String inputFile = "C:/bigdata-data/wc/input/wordcount.txt";
        // 输出路径是 NXLocalFileSystem 的绝对路径
//        String outputDir = "/aa/bb/";

        // 上传测试
//        fs.put(inputFile, outputDir);

        // 创建文件夹测试
//        fs.mkdir(FileSystemUtil.validatePath("/a1/b2/c2/d3"));

        // 下载测试
        fs.get("/aa/bb/wordcount.txt", "d:/");

        // list 测试
//        List<String> pathList = fs.list("/aa/bb/y");
//        for (String path : pathList) {
//            System.out.println(path);
//        }
    }
}
