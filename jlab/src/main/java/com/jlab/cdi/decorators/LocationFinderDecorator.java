package com.jlab.cdi.decorators;

import com.jlab.services.LocationFinder;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.concurrent.Future;

@Decorator
public class LocationFinderDecorator implements LocationFinder {

    @Inject @Delegate LocationFinder locationFinder;

    @Override
    public Future<String> findLocation() {
        System.out.println("DECORATOR");
        return locationFinder.findLocation();
    }
}
