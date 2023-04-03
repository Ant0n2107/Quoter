package com.example.quoter.controller;

import com.example.quoter.entity.Quote;
import com.example.quoter.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/quoter")
public class MainController {
    public List<UserEntity> users = Stream.of(
            new UserEntity(1L, "Ivan","Ivan@mail.com", "Ivan"),
            new UserEntity(2L, "Petr","Petr@mail.com", "Petr"),
            new UserEntity(3L, "Sasha","Petr@mail.com", "Sasha")
    ).collect(Collectors.toList());
    public List<Quote> quotes = Stream.of(
            new Quote(1L, "First","Hello, everyone"),
            new Quote(2L, "Second","Goodbye, everyone")
    ).collect(Collectors.toList());
    @GetMapping("/users")
    public List<UserEntity> getUsers(){
        return users;
    }
    @GetMapping("/quotes")
    public List<Quote> getQuotes(){
        return quotes;
    }
    @GetMapping("/{id}")
    public UserEntity viewOne(@PathVariable Long id){
        return users.stream().filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
