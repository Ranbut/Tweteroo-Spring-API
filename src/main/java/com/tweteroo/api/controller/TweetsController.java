package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.UserRepository;
import com.tweteroo.api.service.TweetsService;

@RestController
@RequestMapping("api/tweets")
public class TweetsController {
    
    @Autowired
    private UserRepository repository;

	@Autowired
	private TweetsService service;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping()
    public Page<Tweet> getLastFiveTweets(@RequestParam(defaultValue = "0") int page) {
        return service.getLastFiveTweets(page);
    }

    @GetMapping("/{username}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tweet> getFromUser(@PathVariable String username){
        return service.findByUsername(username);
    }
    
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public String create(@RequestBody TweetDTO req){
        User user = repository.findByUsername(req.username());

        Tweet tweet = new Tweet();
        tweet.setUsername(req.username());
        tweet.setAvatar(user.getAvatar());
        tweet.setText(req.text());

        service.create(tweet);
        return "OK";
    }
}
