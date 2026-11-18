package com.javatechie.jwt.api;

import com.javatechie.jwt.api.entity.User;
import com.javatechie.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtJavatechieApplication {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initUser(){
        List<User> users = Stream.of(
                new User(101,"javatechie","password","javatechi@gmail.com"),
                new User(102,"marie","pwd1","marie@gmail.com"),
                new User(103,"john","pwd2","john@gmail.com"),
                new User(104,"sam","pwd3","sam@gmail.com")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtJavatechieApplication.class, args);
    }

}
