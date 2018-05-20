package com.jlab.rest;

import com.jlab.entities.Customer;
import com.jlab.persistence.CustomersDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/customers")
public class CustomersController {

    @Inject
    private CustomersDAO customersDAO;

    @Path("")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers() {
        return customersDAO.getAllCustomers();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getById(@PathParam("id") final Integer id) {
        return customersDAO.findById(id);
    }

    @Path("/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer id, Customer customerData){
        try {
            Customer existingCustomer = customersDAO.findById(id);
            if(existingCustomer == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingCustomer.setName(customerData.getName());
            existingCustomer.setAddress(customerData.getAddress());
            customersDAO.update(existingCustomer);
            return Response.ok().build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/create")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Customer customerData){
        try {
            customersDAO.create(customerData);
            return Response.ok().build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
