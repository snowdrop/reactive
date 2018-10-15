package me.snowdrop.reactive.repositories;

import me.snowdrop.reactive.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {

    Mono<Product> getProduct(int id);

    Flux<Product> getAllProducts();

    Mono<Void> saveProduct(Mono<Product> product);

}