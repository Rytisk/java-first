package com.jlab.cdi.specialization;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@ApplicationScoped
@SmartGreeter
@Default
public class LongGreeting {

    public String greet() {
        return "Greetings!";
    }
}
