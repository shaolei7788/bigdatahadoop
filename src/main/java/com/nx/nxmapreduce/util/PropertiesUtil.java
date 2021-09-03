package com.nx.nxmapreduce.util;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * 一个配置文件工具类
 **/
public class PropertiesUtil {

    public static void main(String[] args) {
        Properties properties = loadConf();
        System.out.println(properties.getProperty("nxmapreduce_temp"));
    }

    // 服务名称， 服务实现类
    public static Properties loadConf(){
        String DEFAULT_ENCODING = "UTF-8";
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            URL systemResource = ClassLoader.getSystemResource("nxcompute.properties");
            inputStream = new BufferedInputStream(new FileInputStream(new File(systemResource.getPath())));
            properties.load(new InputStreamReader(inputStream, DEFAULT_ENCODING));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
