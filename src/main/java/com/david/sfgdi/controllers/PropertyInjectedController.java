package com.david.sfgdi.controllers;

import com.david.sfgdi.services.GreetingService;
// Least recommend method !!
public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting(){

        return greetingService.sayGreeting();
    }


}
