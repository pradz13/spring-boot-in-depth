package org.example;

import org.example.bean.DependentClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //Spring way
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("org.example.bean");
        DependentClass dependentClass = annotationConfigApplicationContext.getBean(DependentClass.class);
        dependentClass.executeMethod();

        //Custom way
        CustomBeanFactory customBeanFactory = new CustomBeanFactory();
        DependentClass dependentClassCustom = customBeanFactory.getBean(DependentClass.class);
        dependentClassCustom.executeMethod();
    }
}