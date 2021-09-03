package com.nx.hadoop.lesson04;

public class StopWatch {


    public static void main(String[] args) throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.reset();
        stopWatch.start();
        Thread.sleep(2000);
        long elapse = stopWatch.getElapse();
        System.out.println(elapse);

        stopWatch.reset();
        stopWatch.start();
        Thread.sleep(4000);
        long elapse1 = stopWatch.getElapse();
        System.out.println(elapse1);
    }

    //开始时间
    long start=0L;
    //统计时间流逝的时间
    long elapse=0L;
    public StopWatch() {

    }
    /**
     * 重置时间
     * @return
     */
    public StopWatch reset() {
        //开始时间
        long start=0L;
        //统计时间流逝的时间
        long elapse=0L;
        return this;
    }
    /**
     * 开始计时
     * @return
     */
    public StopWatch start() {
        start=System.currentTimeMillis();
        return this;
    }
    /**
     * 重新计时
     * @return
     */
    public StopWatch restart() {
        return this.reset().start();
    }
    /**
     * 计算流逝的时间
     * @return
     */
    public long getElapse() {
        return System.currentTimeMillis()  - start;
    }

}
