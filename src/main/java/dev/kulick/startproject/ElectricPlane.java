package dev.kulick.startproject;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service("ElectricPlane")
@Primary
public class ElectricPlane implements Plane {

    @Override
    public String getPlaneModel() {
        return "Другой боинг";
    }

    @Override
    public String getPlaneType() {
        return "Электрический";
    }

    @Override
    public Integer getPlaneFuelCapacity() {
        return 1500;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Бин ElectricPlane создан");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Бин ElectricPlane уничтожен");
    }
}