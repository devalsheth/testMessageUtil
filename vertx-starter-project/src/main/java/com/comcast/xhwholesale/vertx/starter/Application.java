package com.comcast.xhwholesale.vertx.starter;

import com.comcast.xhwholesale.template.vertx.foundation.BaseApplication;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * All applications must extend BaseApplication which is a SpringBoot application in the dh-template-spring-vertx
 * dependency. The main method is defined in BaseApplication
 */
@Slf4j
@SpringBootApplication
@PropertySource("classpath:application.yml")
public class Application extends BaseApplication {
    public static void main(String[] args) {
        startApplication( Application.class, args );
    }
}
