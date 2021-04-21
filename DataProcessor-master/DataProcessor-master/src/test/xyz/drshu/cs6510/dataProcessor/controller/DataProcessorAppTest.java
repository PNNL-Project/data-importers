package xyz.drshu.cs6510.dataProcessor.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataProcessorAppTest {

    @InjectMocks
    DataProcessorApp dataProcessorApp = new DataProcessorApp();

    @Mock
    Parser parser = new Parser();

    @Test
    public void mainTestWithException() {
        Exception exception= null;
        try{
            DataProcessorApp.main(new String[] {});
        }catch (Exception e){
            exception = e;
        }
        Assert.assertNotNull(exception);
    }

}