package com.spring.pets;

public class DogPetService implements PetService{

    @Override
    public String getPetType() {
        return "Dog is the best";
    }
}
