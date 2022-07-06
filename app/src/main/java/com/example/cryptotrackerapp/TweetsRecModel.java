package com.example.cryptotrackerapp;

public class TweetsRecModel {
    private int id;
    private String name;
    private String tweet;

    public TweetsRecModel(int id, String name, String tweet) {
        this.id = id;
        this.name = name;
        this.tweet = tweet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}

