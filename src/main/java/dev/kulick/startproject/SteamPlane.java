package dev.kulick.startproject;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service("SteamPlane")
public class SteamPlane implements Plane {

    @Override
    public String getPlaneModel() {
        return "Боинг";
    }

    @Override
    public String getPlaneType() {
        return "Паровой самолет";
    }

    @Override
    public Integer getPlaneFuelCapacity() {
        return 1000;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Бин SteamPlane создан");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Бин SteamPlane уничтожен");
    }

}
