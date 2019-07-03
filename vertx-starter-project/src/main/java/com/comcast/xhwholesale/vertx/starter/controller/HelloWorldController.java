package com.comcast.xhwholesale.vertx.starter.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comcast.xhwholesale.vertx.starter.service.HelloWorld;

@Slf4j
@Component
@Path("/")
public class HelloWorldController
{
    @Autowired
    private HelloWorld helloWorld;

    @GET
    @Path("/hello")
    @Produces({ MediaType.APPLICATION_JSON })
    public String getHelloWorld(@QueryParam("name") String name)
    {
        if (name == null)
        {
            name = "";
        }
        String msg = "Hello " + helloWorld.greet(name).getGreeting() + " from Vertx Project Startup application";
        return msg;
    }
}
