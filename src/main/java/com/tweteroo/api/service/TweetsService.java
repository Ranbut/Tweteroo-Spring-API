package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetsRepository;

@Service
public class TweetsService {

    @Autowired
    private TweetsRepository tweetsRepository;

    public Page<Tweet> getLastFiveTweets(int page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "id"));
        return tweetsRepository.findAll(pageable);
    }

    public List<Tweet> findByUsername(String username){
        return tweetsRepository.findByUsername(username);
    }

	public void create(Tweet data) {
		tweetsRepository.save(data);
	}
}
