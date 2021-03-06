package com.bupt.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

    Logger logger =LoggerFactory.getLogger(getClass());

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads(){
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }

    @Test
    public void testDataSource() throws SQLException {

        System.out.println("dataSource类型：" + dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println("connection连接：" + connection);
        connection.close();
    }






}
