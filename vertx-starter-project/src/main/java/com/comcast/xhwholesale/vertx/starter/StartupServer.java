package com.comcast.xhwholesale.vertx.starter;

import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import lombok.extern.slf4j.Slf4j;

import org.jboss.resteasy.plugins.server.vertx.VertxRequestHandler;
import org.jboss.resteasy.plugins.server.vertx.VertxResteasyDeployment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comcast.xhwholesale.template.vertx.foundation.annotations.VertxServer;
import com.comcast.xhwholesale.template.vertx.foundation.service.Server;

@Slf4j
@Component("startupServerVerticle")
@Scope("prototype")
// Enable multiple instances of the server
@VertxServer("startupserver")
public class StartupServer extends Server
{

    private static final String WEBROOT = "webroot";
    @Value("${httpPort}")
    private int httpPort;
    @Value("${httpsPort}")
    private int httpsPort;

    /**
     * @throws Exception
     */
    public void start(Future<Void> future) throws Exception
    {
        // Overridding start method as base template only provides REST and it
        // does not integrate a static handler
        //
        Router router = Router.router(vertx);
        VertxResteasyDeployment deployment = createResteasyDeployment();
        vertx.createHttpServer(createOptions(false)).requestHandler(router::accept).listen(res -> {
            if (res.succeeded())
            {
                log.info("HTTP/1.1 server running on port {}", getHttp1Port());
                future.complete();
            } else
            {
                future.fail(res.cause());
            }
        });
        routeCoreServices(router);
        // call rest services
        VertxRequestHandler restHandler = new VertxRequestHandler(vertx, deployment);
        router.route("/hello").handler(r -> restHandler.handle(r.request()));
        // call static resources
        router.route().handler(StaticHandler.create().setWebRoot(WEBROOT));

    }

    /**
     * Set the port for HTTP1. This overrides the base class and set to a
     * different port
     */
    public int getHttp1Port()
    {
        return httpPort;
    }

    /**
     * Set the port for HTTP2. This overrides the base class and set to a
     * different port
     */
    public int getHttp2Port()
    {
        return httpsPort;
    }

}
