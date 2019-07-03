# XhWholeSale Vertx Startup Application

This project demonstrates how to develop a micro service using the Vertx ASync template(https://github.comcast.com/xh-wholesale/dh-template-spring-vertx). This project is a startup tool which can be used as a reference to create other micro service applications. 

## Prerequisites:

* Java 8 installed and set as your default VM
* Gradle
* Lombok Plugin, For this project, Lombok annotations are used to reduce boilerplate code. IntelliJ needs a plugin to understand these annotations. Follow instructions at https://projectlombok.org/setup/intellij to install the plugin in IntelliJ. You will only have to do this once. After this is completed, make sure to turn on annotation processing for the Java compiler, which can be found in preferences/build, execution, deployment/compiler/annotation processors. 

## Default Port: 9090

* Change the port from `src/main/resources/application.yml`

## To run this:

1. `./gradlew build`
2. `java -jar ./build/libs/vertx-starter-project.jar` 
3. `curl http://localhost:9090/hello?name=<any name>`
