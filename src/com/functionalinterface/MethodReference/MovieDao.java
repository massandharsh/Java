package com.functionalinterface.MethodReference;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieDao {
    static List<Movie> movieList;
    static{
        movieList = Arrays.asList(
                new Movie("Spiderman",4,100),
                new Movie("Avengers",8,200),
                new Movie("Wolverine",2,1000),
                new Movie("Captain America",9,400)
        );
    }
    public Optional<Movie> findByName(String movieName){
        return movieList.stream().filter((movie)->movie.getTitle()
                .equalsIgnoreCase(movieName))
                .findFirst();
    }
}
