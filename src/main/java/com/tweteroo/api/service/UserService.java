package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

	public void create(User data) {
		repository.save(data);
	}
}
