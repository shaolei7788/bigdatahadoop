package com.nx.nxfs.local;

import com.nx.nxfs.util.FileSystemUtil;
import com.nx.nxfs.util.IOUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 一个文件系统的本地实现类
 **/
public class NXLocalFileSystem implements FileSystem {

    /**
     * 上传文件实现
     *
     * @param inputFile
     * @param outputDir
     * @return
     */
    @Override
    public void put(String inputFile, String outputDir) {

        // 解析存放目录
        File input = new File(inputFile);
        String fileName = input.getName();
        String outputPathDir = FileSystemUtil.validatePath(outputDir);

        // 如果文件已存在
        String destOutputPath = outputPathDir + fileName;
        if (new File(destOutputPath).exists()) {
            return;
        }

        // 如果父目录不存在，则创建
        if (!new File(outputPathDir).exists()) {
            mkdir(outputPathDir);
        }

        // 数据处理：文件拷贝
        IOUtils.copyFile(inputFile, destOutputPath);
    }

    /**
     * 下载文件实现
     *
     * @param sourceFile 下载文件
     * @param destDir    存放目录
     */
    @Override
    public void get(String sourceFile, String destDir) {

        String perfectInputPath = FileSystemUtil.validatePath(sourceFile);

        String perfectOutputPath = destDir + new File(perfectInputPath).getName();

        System.out.println(perfectInputPath + "\n" + perfectOutputPath);

        IOUtils.copyFile(perfectInputPath, perfectOutputPath);
    }

    /**
     * 创建一个目录
     *
     * @param mkdir 完整路径，非 文件系统路径。
     *              已经实现了递归的效果
     *
     *              /c1/c2/c3/cc54/
     */
    @Override
    public void mkdir(String mkdir) {

        // 当前目录
        File currentDir = new File(mkdir);

        // 父目录
        File parentDir = currentDir.getParentFile();

        // 如果不存在，递归创建
        if (!parentDir.exists()) {
            mkdir(currentDir.getParent());
        }
        currentDir.mkdir();
    }

    /**
     * LIST实现
     *
     * @param inputPath
     * @return
     */
    @Override
    public List<String> list(String inputPath) {

        String perfectPath = FileSystemUtil.validatePath(inputPath);
        File currentPath = new File(perfectPath);
        if (currentPath.isFile()) {
            System.out.println("您指定的路径是文件，无法展示子节点内容");
            return null;
        } else {
            File[] list = currentPath.listFiles();
            List<String> pathList = new ArrayList<String>();
            for (File f : list) {
                pathList.add(f.getAbsolutePath().replace("\\", "/").replace(rootDir, ""));
            }
            return pathList;
        }
    }
}
