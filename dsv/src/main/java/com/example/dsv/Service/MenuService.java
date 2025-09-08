package com.example.dsv.Service;

import com.example.dsv.Model.Product;
import reactor.core.publisher.Flux;

public interface MenuService {


    Flux<Product> getMenu();
}
