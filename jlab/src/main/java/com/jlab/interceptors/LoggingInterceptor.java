package com.jlab.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@Logging
public class LoggingInterceptor implements Serializable {

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        String name = context.getMethod().getName();
        String params = context.getParameters().toString();
        System.out.println("Method: " + name + ". Parameters: " + params);
        return context.proceed();
    }
}
