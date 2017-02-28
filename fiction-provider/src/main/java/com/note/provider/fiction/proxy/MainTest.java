package com.note.provider.fiction.proxy;

import com.alibaba.dubbo.container.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/8.
 */
public class MainTest {

    public static void main(String[] args) throws IOException, SQLException {
        Logger logger = LoggerFactory.getLogger(MainTest.class);
        logger.trace("trace");
//        ClassPathXmlAppl icationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring/applicationContext.xml"});
//        context.start();
//        FictionServiceProxy fictionServiceProxy = (FictionServiceProxy) context.getBean("fiction.service.fictionServiceProxy");
//        String list =  fictionServiceProxy.search();
//        System.out.println(list);
        Main.main(args);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        System.in.read(); // 按任意键退出
    }
}
