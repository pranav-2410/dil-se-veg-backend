package com.example.dsv.Controller;

import com.example.dsv.Model.Product;
import com.example.dsv.Service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/getMenu")
    public Flux<Product> getMenu() {

        return menuService.getMenu();
    }

    @GetMapping("/getItem")
    public Mono<Product> getItem(@RequestParam String id){
        return menuService.getItem(id);
    }
}
