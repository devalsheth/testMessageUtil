package com.comcast.xhwholesale.vertx.starter;

import static javax.ws.rs.core.Response.Status.OK;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.comcast.xhwholesale.vertx.starter.Application;

@RunWith(VertxUnitRunner.class)
public class HelloWorldControllerTest
{

    public static int PORT = 9090;
    private Vertx vertx = Vertx.vertx();

    /**
     * This starts the application server
     */
    @BeforeClass
    public static void initOnce()
    {
        System.setProperty("spring.profiles.active", "dev");
        Application.main(null);
    }

    /**
     * Test the simple endpoint!
     *
     * @param context
     */
    @Test
    public void getGreetingMessage(TestContext context)
    {
        final Async async = context.async();

        vertx.createHttpClient().get(PORT, "localhost", "/hello?name=xyz", response -> {
            context.assertEquals(OK.getStatusCode(), response.statusCode());
            response.bodyHandler(body -> {
                context.assertTrue(body.toString().contains(" from Vertx Project Startup application"));
                async.complete();
            });
        }).end();
    }

}
