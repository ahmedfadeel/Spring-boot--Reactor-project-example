package com.example.reactive_programming.model;

import java.util.stream.Stream;

public class StreamSource {

    public static Stream <String> getStringStream() {
       return   Stream.of("one", "two", "three", "four","five", "six", "seven");
    }
    public static Stream <Integer> getIntStream() {
        return   Stream.iterate ( 0,i->i+2 ).limit ( 10 );
    }

    public static Stream <User> getUserStream() {
        return Stream.of(
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
