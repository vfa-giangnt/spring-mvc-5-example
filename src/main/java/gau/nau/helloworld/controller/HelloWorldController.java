package gau.nau.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

import gau.nau.helloworld.model.HelloWorld;

@Controller
public class HelloWorldController {
    @RequestMapping("/helloworld")
    public String handler(Model model) {

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello world example using Spring 5 MVC!!!");
        helloWorld.setDateTime(LocalDateTime.now().toString());
        model.addAttribute("helloWorld", helloWorld);

        return "helloworld";
    }
}
