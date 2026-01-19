package com.shivam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Dev obj = context.getBean(Dev.class);
        // we can also use
        // by default it returns Object type so we have to typecast it
        // "dev" is id
//        Dev obj = (Dev) context.getBean("dev");
//        obj.age = 18;
        // here we dont need to type cast cause we are searching byType
        Dev obj = context.getBean(Dev.class);
//        obj.setAge(18);

//        System.out.println(obj.age);
//        System.out.println(obj.getAge());

        obj.build();

        // in simple java
//      Dev obj = new Dev();
//      obj.build();
    }
}
