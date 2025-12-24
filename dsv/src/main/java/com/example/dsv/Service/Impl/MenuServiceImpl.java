package com.example.dsv.Service.Impl;

import com.example.dsv.Model.Product;
import com.example.dsv.Repository.MenuRepository;
import com.example.dsv.Service.MenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepo;

    private final ObjectMapper objectMapper;

    public MenuServiceImpl(MenuRepository menuRepo, ObjectMapper objectMapper) {
        this.menuRepo = menuRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public Flux<Product> getMenu() {
        return menuRepo.findAll().doOnNext(product ->
        {
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

    }

    @Override
    public Mono<Product> getItem(String id) {
        return menuRepo.findById(id);
    }
}
