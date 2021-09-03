package com.nx.rpc.netty1.service;

import java.util.Date;

/**
 * TODO_MA 提供两个服务： 获取现在的服务器时间， 和  转换日期的格式
 **/
public interface DateTimeService {

    String hello(String name);

    // 获取现在的时间
    String getNow();

    // 换换日期格式
    String format(String format, Date date);

    // 换换日期格式
    String format(Date date);
}
