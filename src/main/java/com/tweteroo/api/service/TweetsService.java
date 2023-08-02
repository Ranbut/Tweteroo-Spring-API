package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetsRepository;

@Service
public class TweetsService {

    @Autowired
    private TweetsRepository repository;

    public List<Tweet> findAll(){
        return repository.findAll();
    }

    public List<Tweet> findByUsername(String username){
        return repository.findByUsername(username);
    }

	public void create(Tweet data) {
		repository.save(data);
	}
}
