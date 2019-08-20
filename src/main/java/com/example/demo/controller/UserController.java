package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Mono<User> getUser() {
        User user = new User();
        user.setName("犬小哈");
        user.setDesc("欢迎关注我的公众号: 小哈学Java");
        return Mono.just(user);
    }

    @GetMapping("")
    public Flux<User> list() {
        UserService userService1 = new UserService();
        return this.userService.list();
    }

    @GetMapping("/{id}")
    public Mono<User>getById(@PathVariable("id") final String id) {
        return this.userService.getById(id);
    }

    @PostMapping("")
    public Mono<User> create(@RequestBody final User user) {
        return this.userService.createOrUpdate(user);
    }

    @PutMapping("/{id}")
    public Mono<User>  update(@PathVariable("id") final String id, @RequestBody final User user) {
        Objects.requireNonNull(user);
        user.setId(id);
        return this.userService.createOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public Mono<User>  delete(@PathVariable("id") final String id) {
        return this.userService.delete(id);
    }
}
