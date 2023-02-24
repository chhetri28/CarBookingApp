package com.springboot.car.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/home")
	public String home(){
        return "This is home page tested by Sourav";
    }
}
