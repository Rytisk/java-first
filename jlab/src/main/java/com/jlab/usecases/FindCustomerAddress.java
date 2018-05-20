package com.jlab.usecases;

import com.jlab.interceptors.Logging;
import com.jlab.services.LocationFinder;
import com.jlab.services.SimpleLocationFinder;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class FindCustomerAddress implements Serializable {

    @Inject
    private LocationFinder locationFinder;

    private Future<String> locationFindingTask = null;

    @Logging
    public String findCustomerLocation() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        locationFindingTask = locationFinder.findLocation();
        return "/customer.xhtml?faces-redirect=true&customerId=" + requestParameters.get("customerId");
    }

    public boolean isLocationFindingRunning() {
        return locationFindingTask != null && !locationFindingTask.isDone();
    }

    public String getLocationFindingStatus() throws ExecutionException, InterruptedException {
        if (locationFindingTask == null) {
            return null;
        } else if(isLocationFindingRunning()) {
            return "Location finding is in progress";
        }

        return "Your location: " + locationFindingTask.get();
    }
}
