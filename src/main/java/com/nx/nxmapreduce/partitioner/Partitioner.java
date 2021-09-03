package com.nx.nxmapreduce.partitioner;

/**
 * Author： 马中华 奈学教育 https://blog.csdn.net/zhongqi2513
 **/
public class Partitioner {

    private int numPartitions;

    public Partitioner() {
    }

    public Partitioner(int numPartitions) {
        this.numPartitions = numPartitions;
    }

    public int getPatition(String key, int value, int numPatitions){
        return (key.hashCode() & Integer.MAX_VALUE) % numPatitions;
    }

    public int getNumPartitions() {
        return numPartitions;
    }

    public void setNumPartitions(int numPartitions) {
        this.numPartitions = numPartitions;
    }
}
