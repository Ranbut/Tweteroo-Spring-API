package com.tweteroo.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Tweet;

public interface TweetsRepository extends JpaRepository<Tweet, Long> {
    Page<Tweet> findTop5ByOrderByIdDesc(Pageable pageable);
    List<Tweet> findByUsername(String username);
}
