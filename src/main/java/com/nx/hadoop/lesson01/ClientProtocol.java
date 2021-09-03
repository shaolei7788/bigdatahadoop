package com.nx.hadoop.lesson01;

public interface ClientProtocol {
    long versionID = 1234L;
    void makeDir(String path);

    void regisger(String hostname,int port);
}
