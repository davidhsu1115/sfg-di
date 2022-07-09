package com.david.sfgdi;

import com.david.sfgdi.config.SfgConstructorConfig;
import com.david.sfgdi.controllers.*;
import com.david.sfgdi.datasource.FakedataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {

        ApplicationContext ctx =  SpringApplication.run(SfgDiApplication.class, args);

        System.out.println("----- Property with Spring");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("----- Setter with Spring");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("----- Constructor with Spring");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("----- Spring Profile");
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        System.out.println("----- Primary Bean");
        MyController myController = (MyController) ctx.getBean("myController");
        System.out.println(myController.syHello());

        System.out.println("---- Pet Factory");
        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println(petController.getType());

        System.out.println("--- External source: .properties");
        FakedataSource fakedataSource = ctx.getBean(FakedataSource.class);
        System.out.println(fakedataSource.getUsername());
        System.out.println(fakedataSource.getPassword());
        System.out.println(fakedataSource.getDbUrl());

        System.out.println("--- Constructor Binding");
        SfgConstructorConfig sfgConstructorConfig = ctx.getBean(SfgConstructorConfig.class);
        System.out.println(sfgConstructorConfig.getUsername());
        System.out.println(sfgConstructorConfig.getPassword());
        System.out.println(sfgConstructorConfig.getDbUrl());

    }

}
