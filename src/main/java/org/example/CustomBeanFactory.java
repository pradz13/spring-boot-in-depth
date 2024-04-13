package org.example;

import org.example.bean.DependentClass;
import org.example.bean.IndependentClass;

import java.util.HashMap;
import java.util.Map;

public class CustomBeanFactory {
    private Map<Class<?>, Object> beans = initBeans();

    private Map<Class<?>, Object> initBeans() {
        Map<Class<?>, Object> beanMap = new HashMap<>();
        IndependentClass independentClass = new IndependentClass();
        DependentClass dependentClass = new DependentClass(independentClass);
        beanMap.put(IndependentClass.class, independentClass);
        beanMap.put(DependentClass.class, dependentClass);
        return beanMap;
    }

    public <T> T getBean(Class<?> clazz) {
        return (T) beans.get(clazz);
    }
}
