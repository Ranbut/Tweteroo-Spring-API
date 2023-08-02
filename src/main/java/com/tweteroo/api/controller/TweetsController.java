package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.service.TweetsService;

@RestController
@RequestMapping("/tweets")
public class TweetsController {
    
	@Autowired
	private TweetsService service;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tweet> getAll(){
        return service.findAll();
    }

    @GetMapping("/{username}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tweet> getFromUser(@PathVariable String username){
        return service.findByUsername(username);
    }
    
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public String create(@RequestBody TweetDTO req){
        service.create(new Tweet(req));
        return "OK";
    }
}
