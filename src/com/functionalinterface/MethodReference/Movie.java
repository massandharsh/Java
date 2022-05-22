package com.functionalinterface.MethodReference;

import java.time.LocalDateTime;

public class Movie {
    Double id;
    String title;
    LocalDateTime duration;
    int ratings;
    int price;

    public Movie(String title, int ratings, int price) {
        this.title = title;
        this.ratings = ratings;
        this.price = price;
        this.id = Math.random();
    }

    @Override
    public String toString() {
        return "MovieDao{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", ratings=" + ratings +
                ", price=" + price +
                '}';
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDuration() {
        return duration;
    }

    public void setDuration(LocalDateTime duration) {
        this.duration = duration;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
