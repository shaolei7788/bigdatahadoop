package com.nx.rpc.netty1.service.impl;

import com.nx.rpc.netty1.service.DateTimeService;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateTimeService 的服务实现类
 **/
public class DateTimeServiceImpl implements DateTimeService {

    private String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
    private SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    @Override
    public String hello(String name) {
        return "I'm Server, Hello My Dear Client: " + name;
    }

    // 获取现在的时间
    @Override
    public String getNow() {
        return sdf.format(new Date());
    }

    // 转换日期格式
    @Override
    public String format(String format, Date date) {
        if (format == null || "".equals(format)) {
            return sdf.format(date);
        } else {
            SimpleDateFormat sdf1 = new SimpleDateFormat(format);
            return sdf1.format(date);
        }
    }

    @Override
    public String format(Date date) {
        return sdf.format(date);
    }
}
