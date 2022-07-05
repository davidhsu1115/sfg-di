package com.david.sfgdi.controllers;

import com.spring.pets.PetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PetController{
    
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }
    
    public String getType(){
        return petService.getPetType();
    }
}
