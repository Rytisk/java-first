package com.jlab.services;

import java.util.concurrent.Future;

public interface LocationFinder {
    Future<String> findLocation();
}
