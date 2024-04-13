package org.example.bean;

import org.springframework.stereotype.Component;

@Component
public class IndependentClass {

    public void executeMethod() {
        System.out.println("Executing method");
    }
}
