package me.snowdrop.reactive.handlers;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface ProductHandler {
    public Mono<ServerResponse> getProductFromRepository(ServerRequest request);

    public Mono<ServerResponse> saveProductToRepository(ServerRequest request);

    public Mono<ServerResponse> getAllProductsFromRepository(ServerRequest request);
}