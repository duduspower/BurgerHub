package com.example.BurgerApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doubleBurger")
public class DoubleBurgerController {
    @GetMapping
    public String getDoubleBurger(){
        return "doubleBurger";
    }

}
