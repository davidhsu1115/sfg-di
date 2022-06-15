package com.david.sfgdi.controllers;

import com.david.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

// Most recommend method !!
@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    // @Autowired Optional in Spring 4.2 or later
    // If remove @Qualifier will get error unless "Primary Bean" has been set.
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
