package com.jlab.cdi.specialization;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;

@Alternative
@Specializes
public class MockLongGreeting extends LongGreeting {
    @Override
    public String greet() {
        return "MOCK Greeting";
    }
}
