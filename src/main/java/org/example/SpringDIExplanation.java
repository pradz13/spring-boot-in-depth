package org.example;

import org.example.bean.DependentClass;
import org.example.bean.IndependentClass;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Set;

public class SpringDIExplanation {
    public static void main(String[] args) throws Exception {

        //Scan all the classes and identify the classes with @Component annotation
        ClassPathScanningCandidateComponentProvider scanner
                = new ClassPathScanningCandidateComponentProvider(true);

        scanner.addIncludeFilter(new AnnotationTypeFilter(Component.class));
        Set<BeanDefinition> beanDefinitions = scanner.findCandidateComponents("org.example.bean");

        for(BeanDefinition beanDefinition : beanDefinitions) {
            System.out.println(beanDefinition.getBeanClassName());
        }

        //Identify the bean dependencies using reflection
        printConstructors(IndependentClass.class);

        //Create instance of beans using reflection
        createInstance();
    }

    static void printConstructors(Class<?> type) {
        Constructor<?>[] constructors = type.getConstructors();
        Parameter[] parameters = constructors[0].getParameters();
        for(Parameter parameter :  parameters) {
            System.out.println(parameter.getType());
        }
    }

    static void createInstance() throws Exception {
        IndependentClass independentClass =
                (IndependentClass) Class.forName(IndependentClass.class.getName()).getDeclaredConstructors()[0].newInstance();

        DependentClass dependentClass =
                (DependentClass) Class.forName(DependentClass.class.getName()).getDeclaredConstructors()[0].newInstance(independentClass);

        dependentClass.executeMethod();
    }
}
