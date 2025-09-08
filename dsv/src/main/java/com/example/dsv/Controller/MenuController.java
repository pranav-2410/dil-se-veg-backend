package com.example.dsv.Controller;

import com.example.dsv.Model.Product;
import com.example.dsv.Service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/menu")
public class MenuController {

    MenuService menuService;

    @GetMapping("/getMenu")
    public Flux<Product> getMenu() {

        return menuService.getMenu();
    }
}
