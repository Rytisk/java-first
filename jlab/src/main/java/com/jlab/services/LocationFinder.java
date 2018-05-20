package com.jlab.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.concurrent.Future;

@ApplicationScoped
public class LocationFinder implements Serializable {

    @Futureable
    public Future<String> findLocation() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        return new AsyncResult<>("Street st. 14, City");
    }
}
