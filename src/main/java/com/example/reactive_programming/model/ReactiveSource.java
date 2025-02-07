package com.example.reactive_programming.model;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveSource {

    public static Flux <String> getStringFlux ( ) {
        return Flux.just("one", "two", "three","four", "five", "six", "seven", "eight", "nine")
                .delayElements ( Duration.ofSeconds ( 1) );
    }

    public static Flux<Integer> getNumberFlux ( ) {
        return Flux.range ( 1, 10 )
                .delayElements ( Duration.ofSeconds ( 1) );
    }
    public static Flux<Integer> getNumberFluxWithException ( ) {
        return Flux.range ( 1, 10 )
                .delayElements ( Duration.ofSeconds ( 1) )
                .map(e->
                {
                   if (e== 5)
                       throw new RuntimeException ("An error happened in the flux ");
                   return 0;
                });
    }
    public static Mono <Integer> getNumberMono ( ) {
        return Mono.just ( 43 )
                .delayElement( Duration.ofSeconds ( 1) );
    }

    public static Flux<User> getUserFlux ( ) {
         return Flux.just (
                 new User(1, "John", "Doe"),
                 new User(2, "Jane", "Doe"),
                 new User(3, "Jim", "Beam"),
                 new User(4, "Jack", "Daniels"),
                 new User(5, "Johnny", "Walker"),
                 new User(6, "George", "Smith"),
                 new User(7, "William", "Grant"),
                 new User(8, "James", "Bond"),
                 new User(9, "Bruce", "Wayne"),
                 new User(10, "Clark", "Kent"),
                 new User(11, "Peter", "Parker"),
                 new User(12, "Tony", "Stark")
                          );

    }




















}
