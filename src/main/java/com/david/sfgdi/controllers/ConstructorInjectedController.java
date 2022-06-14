package com.david.sfgdi.controllers;

import com.david.sfgdi.services.GreetingService;
// Most recommend method !!
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
