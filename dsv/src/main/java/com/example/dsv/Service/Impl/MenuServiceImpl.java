package com.example.dsv.Service.Impl;

import com.example.dsv.Model.Product;
import com.example.dsv.Service.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {


    @Override
    public List<Product> getMenu() {
        return menuRepo.getAll();
    }
}
