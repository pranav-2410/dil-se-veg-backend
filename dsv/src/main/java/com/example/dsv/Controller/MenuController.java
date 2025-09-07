package com.example.dsv.Controller;

import com.example.dsv.Model.Product;
import com.example.dsv.Service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    MenuService menuService;

    @GetMapping("/getMenu")
    public List<Product> getMenu() {

        return menuService.getMenu();
    }
}
