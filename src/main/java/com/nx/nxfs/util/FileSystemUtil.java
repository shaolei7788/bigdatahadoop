package com.nx.nxfs.util;

import com.nx.nxfs.local.FileSystem;

import java.io.File;

/**
 * 一个文件系统工具类
 **/
public class FileSystemUtil {

    // 将文件系统的路径拼接成可用的路径
    public static String validatePath(String path) {
        return (FileSystem.rootDir + "/" + path)
                .replace("/", "/")
                .replace("//", "/");
    }

    public static String validatePath(File path) {
        return FileSystem.rootDir + "/" + path.toString();
    }

    // 将文件系统的路径拼接成一个完整的可用路径
    public static String validatePath(String dir, String fileName) {
        return (FileSystem.rootDir + "/" + dir + "/" + fileName)
                .replace("/", "/")
                .replace("//", "/");
    }

    public static String getFileSystemPath(String path) {
        return path.substring(FileSystem.rootDir.length());
    }

    public static String getFileSystemPath(File path) {
        return path.toString().substring(FileSystem.rootDir.length());
    }

//    /**
//     * 往文件目录树添加节点元数据
//     * nodePath ==> /aa/bb/cc.txt
//     */
//    public static void addNode(String nodePath) {
//        String[] nodeNames = nodePath.split("/");
//
//        FSNode parentNode = FileSystem.root;
//        for (int i = 1; i < nodeNames.length; i++) {
//
//            // 获取节点（根据节点 name 获取 Node）
//            // 如果存在，继续获取，否则，就创建Node 加入进去
//            FSNode currentNode = FileSystemUtil.getChildNode(nodeNames[i]);
//
//            // 如果当前这个node不存在
//            if(currentNode == null){
//                FSDirectory node = new FSDirectory(nodeNames[i]);
//                parentNode.addNode(nodeNames[i]);
//            }
//            parentNode = currentNode;
//        }
//    }
//
//    public static FSNode getChildNode(String nodeName) {
//
//        return null;
//    }
//
//    public static FSNode findNodeByNodeName(String nodeName) {
//
//        FSNode root = FileSystem.root;
//        for (FSNode node : root.getChildren()){
//            if(node.getNodeName().equals(nodeName)){
//                return node;
//            }
//        }
//
//        return null;
//    }
}
