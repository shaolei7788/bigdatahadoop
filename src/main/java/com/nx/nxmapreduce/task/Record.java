package com.nx.nxmapreduce.task;

/**
 * Author： 马中华 奈学教育 https://blog.csdn.net/zhongqi2513
 **/
public class Record {

    private String key;
    private int value;

    @Override
    public String toString() {
        return key + "\t" + value;
    }

    public Record() {
    }

    public Record(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
