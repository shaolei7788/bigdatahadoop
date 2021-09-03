package com.nx.nxfs.distributed;

/**
 * 一个服务器
 **/
public class Server {

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    private String serverPath = null;

    public Server(String serverPath) {
        this.serverPath = serverPath;
    }

    public Server() {
    }
}
