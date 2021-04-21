package xyz.drshu.cs6510.dataProcessor.controller;

import org.junit.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import xyz.drshu.cs6510.dataProcessor.model.Common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@RunWith(JUnit4.class)
public class MyBatisTest{

    @Test
    public void testMybaits() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        Common common1 = new Common();
        common1.setSummer(true);
        common1.setWorkingHours(true);
        common1.setHeatingConsumption(1.1d);
        common1.setTime(new Date());
        common1.setCoolingConsumption(1.2d);
        common1.setExternalTemperature(1.3d);
        common1.setWeekday(false);
        session.insert("CommonMapper.insert",common1);

        session.commit();

        session.close();
    }
}
