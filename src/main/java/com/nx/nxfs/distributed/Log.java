package com.nx.nxfs.distributed;

/**
 *
 **/
public class Log {

    String nodeName;
    String fsPath;
    boolean putOrDelete;        // true表示put，false表示delete

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getFsPath() {
        return fsPath;
    }

    public void setFsPath(String fsPath) {
        this.fsPath = fsPath;
    }

    public boolean isPutOrDelete() {
        return putOrDelete;
    }

    public void setPutOrDelete(boolean putOrDelete) {
        this.putOrDelete = putOrDelete;
    }

    public Log(String nodeName, String fsPath, boolean putOrDelete) {
        this.nodeName = nodeName;
        this.fsPath = fsPath;
        this.putOrDelete = putOrDelete;
    }

    public Log() {
    }

    @Override
    public String toString() {
        return nodeName + "," + fsPath + "," + putOrDelete;
    }
}
