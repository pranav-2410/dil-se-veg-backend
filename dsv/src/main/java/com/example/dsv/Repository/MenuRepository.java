package com.example.dsv.Repository;

import com.example.dsv.Model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends ReactiveCrudRepository<Product, String> {

}
