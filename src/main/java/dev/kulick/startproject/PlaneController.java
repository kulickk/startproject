package dev.kulick.startproject;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
public class PlaneController {
    // @AutoWired через поле, с @Primary
    @Autowired
    private Plane primaryPlaneField;

    // @AutoWired через поле, с @Qualifier
    @Autowired
    @Qualifier("ElectricPlane")
    private Plane qualifierPlaneField;

    // @Autowired через конструктор
    private final Plane planeConstructor;

    @Autowired
    public PlaneController(Plane plane) {
        this.planeConstructor = plane;
    }

    // @Autowired через метод, setter
    public Plane planeSetter;

    @Autowired
    public void setPlane(Plane plane) {
        this.planeSetter = plane;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Бин PlaneController создан");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Бин PlaneController создан");
    }

    @GetMapping("/api/v1/")
    public ArrayList<Object> getPlanes() {
        var list = new ArrayList<>();
        list.add(primaryPlaneField);
        list.add(qualifierPlaneField);
        list.add(planeConstructor);
        list.add(planeSetter);
        return list;
    }
}
