package com.david.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello - Primary bean";
    }
}
