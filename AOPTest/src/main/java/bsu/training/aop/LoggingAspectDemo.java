package bsu.training.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * User: iason
 * Date: 01.06.14
 */
public class LoggingAspectDemo {
    public static void main(String[] args) {
        ApplicationContext cntx =
                new FileSystemXmlApplicationContext("context.xml");
        TestBean testBean = (TestBean) cntx.getBean("test");
        testBean.work();
        testBean.stop();
    }
}

