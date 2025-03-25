package dev.kulick.startproject.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.kulick.startproject.exceptions.CustomException;
import dev.kulick.startproject.models.JsonRequest;

import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class JsonController {

    @PostMapping("/json")
    public JsonRequest handleJsonRequest(@RequestBody JsonRequest request) {
        int id = generateId();
        if (id == 7) {
            throw new CustomException("Произошла ошибка, этот id уже занят");
        }
        request.getInfo().setId(id);

        return request;
    }

    private int generateId() {
        return new Random().nextInt(100);
    }

}
