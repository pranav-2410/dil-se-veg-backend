package com.example.dsv.Service;

import com.example.dsv.Model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MenuService {


    Flux<Product> getMenu();

    Mono<Product> getItem(String id);
}
