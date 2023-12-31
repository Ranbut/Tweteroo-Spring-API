package com.tweteroo.api.model;

import com.tweteroo.api.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {

    public Tweet(TweetDTO data){
        this.username = data.username();
        this.text = data.text();
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 255, nullable = false)
    private String avatar;

    @Column(length = 255, nullable = false)
    private String text;
}
