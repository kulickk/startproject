package dev.kulick.startproject.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping("/headers")
    public String handleHeadersRequest(@RequestHeader Map<String, String> headers, Model model) {
        model.addAttribute("headers", headers);
        return "headers-page";
    }

    @GetMapping("/headers/json")
    @ResponseBody
    public Map<String, String> handleHeadersJson(@RequestHeader Map<String, String> headers) {
        return headers;
    }
}