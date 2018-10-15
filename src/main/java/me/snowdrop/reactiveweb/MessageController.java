package me.snowdrop.reactiveweb;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Arrays;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@RestController
@RequestMapping
class MessageController {

   /* Using MessageClass
    @GetMapping
    Flux<Message> allMessages(){
        return Flux.just(
                Message.builder().body("hello Spring 5").build(),
                Message.builder().body("hello Spring Boot 2").build()
        );
    }*/

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/"),
                (req)-> ok()
                        .body(
                                BodyInserters.fromObject(
                                        Arrays.asList(Message.builder().body("hello Spring 5").build(),
                                                Message.builder().body("hello Spring Boot 2").build()
                                        )
                                )
                        )
        );
    }
}