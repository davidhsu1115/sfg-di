package com.spring.pets;

public class CatPetService implements PetService{
    @Override
    public String getPetType() {
        return "Cat is the best";
    }
}
