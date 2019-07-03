package com.comcast.xhwholesale.vertx.starter.service;

import org.springframework.stereotype.Component;

import com.comcast.xhwholesale.vertx.starter.model.Greeting;

@Component
public class HelloWorld
{

    public Greeting greet(String name)
    {
        Greeting greeting = new Greeting();
        greeting.setGreeting(name);
        return greeting;
    }
}