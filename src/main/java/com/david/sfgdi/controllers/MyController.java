package com.david.sfgdi.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String syHello(){
        System.out.println("Hello");

        return "Hi";
    }

}
