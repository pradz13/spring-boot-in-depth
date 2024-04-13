package org.example.bean;

import org.springframework.stereotype.Component;

@Component
public class DependentClass {

    private final IndependentClass independentClass;

    public DependentClass(IndependentClass independentClass) {
        this.independentClass = independentClass;
    }

    public void executeMethod() {
        independentClass.executeMethod();
    }
}
