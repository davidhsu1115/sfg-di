package com.david.sfgdi.config;

import com.david.sfgdi.datasource.FakedataSource;
import com.david.sfgdi.repositories.EnglishGreetingRepository;
import com.david.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.david.sfgdi.services.*;
import com.spring.pets.CatPetService;
import com.spring.pets.DogPetService;
import com.spring.pets.PetService;
import com.spring.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(SfgConstructorConfig.class)
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakedataSource fakedataSource(SfgConstructorConfig sfgConstructorConfig){
        FakedataSource fakedataSource = new FakedataSource();
        fakedataSource.setUsername(sfgConstructorConfig.getUsername());
        fakedataSource.setPassword(sfgConstructorConfig.getPassword());
        fakedataSource.setDbUrl(sfgConstructorConfig.getDbUrl());
        return fakedataSource;
    }

    // -- Factory
    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Primary
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }



    // -- Primary
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    // DI----
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }
    // ----

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

}
