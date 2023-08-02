package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.User;
import com.tweteroo.api.service.UserService;

@RestController
@RequestMapping("/sign-up")
public class UserController {
    
	@Autowired
	private UserService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public String create(@RequestBody UserDTO req){
        service.create(new User(req));
        return "OK";
    }
}
