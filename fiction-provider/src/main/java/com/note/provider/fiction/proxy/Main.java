package com.note.provider.fiction.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 启动类
 */
public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.trace("trace");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/applicationContext.xml"});
//        context.start();
//        FictionServiceProxy fictionServiceProxy = (FictionServiceProxy) context.getBean("fiction.service.fictionServiceProxy");
//        String list =  fictionServiceProxy.search("");
//        System.out.println(list);
        com.alibaba.dubbo.container.Main.main(args);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        System.in.read(); // 按任意键退出
    }
}
