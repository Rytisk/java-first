package com.jlab.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.concurrent.Future;

@ApplicationScoped
@Alternative
public class FancyLocationFinder implements Serializable, LocationFinder {

    @Futureable
    public Future<String> findLocation() {
        System.out.println("Fancy location search");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        return new AsyncResult<>("Street st. 14, City");
    }
}
