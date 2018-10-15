package me.snowdrop.reactiveweb;

import me.snowdrop.reactiveweb.handlers.ProductHandler;
import me.snowdrop.reactiveweb.handlers.ProductHandlerImpl;
import me.snowdrop.reactiveweb.repositories.ProductImplRepository;
import me.snowdrop.reactiveweb.repositories.ProductRepository;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

public class Server {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.startTomcatServer("localhost", 8080);
        System.out.println("Press ENTER to exit.");
        System.in.read();
    }

    public RouterFunction<ServerResponse> routingFunction() {
        ProductRepository repository = new ProductImplRepository();
        ProductHandler handler = new ProductHandlerImpl(repository);

        return nest(path("/product"),
                nest(accept(APPLICATION_JSON),
                        route(GET("/{id}"), handler::getProductFromRepository)
                                .andRoute(method(HttpMethod.GET), handler::getAllProductsFromRepository)
                ).andRoute(POST("/")
                        .and(contentType(APPLICATION_JSON)), handler::saveProductToRepository));
    }

/*    public void startReactorServer(String host, int port) throws InterruptedException {
        RouterFunction route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer server = HttpServer.create(host, port);
        server.newHandler(adapter).block();
    }*/

    public void startTomcatServer(String host, int port) throws LifecycleException {
        RouterFunction<?> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        Tomcat tomcatServer = new Tomcat();
        tomcatServer.setHostname(host);
        tomcatServer.setPort(port);
        Context rootContext = tomcatServer.addContext("", System.getProperty("java.io.tmpdir"));
        ServletHttpHandlerAdapter servlet = new ServletHttpHandlerAdapter(httpHandler);
        Tomcat.addServlet(rootContext, "httpHandlerServlet", servlet);
        rootContext.addServletMappingDecoded("/", "httpHandlerServlet");
        tomcatServer.start();
    }
}