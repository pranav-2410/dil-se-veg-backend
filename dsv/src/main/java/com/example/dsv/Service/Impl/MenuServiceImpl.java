package com.example.dsv.Service.Impl;

import com.example.dsv.Model.Product;
import com.example.dsv.Repository.MenuRepository;
import com.example.dsv.Service.MenuService;
import reactor.core.publisher.Flux;

public class MenuServiceImpl implements MenuService {

    MenuRepository menuRepo;

    @Override
    public Flux<Product> getMenu() {
        return menuRepo.findAll();
    }
}
