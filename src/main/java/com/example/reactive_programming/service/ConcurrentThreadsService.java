package com.example.reactive_programming.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class ConcurrentThreadsService {


    // this class is an example for ConcurrentHashMap in a multiThreading environment
    static Map <Integer, String> map = new ConcurrentHashMap <> (  );

    public static void main(String[] args) {
        // Thread t1 adds key-value pairs 0-9
        Thread t1 = new Thread ( ( ) -> {
            Stream.iterate ( 0 , i -> i + 1 )
                    .limit ( 10 ).forEach ( i -> map.put ( i , String.valueOf ( i+"t1" ) ) );
        } );
        t1.start ( );

        // Thread t2 adds key-value pairs 10-19
        Thread t2 = new Thread ( ( ) -> {
            Stream.iterate ( 0 , i -> i + 1 )
                    .limit ( 10 ).forEach ( i -> map.put ( i , String.valueOf ( i +"t2" ) ) );
        } );
        t2.start ( );

        // Thread t3 adds key-value pairs 20-29
        Thread t3 = new Thread ( ( ) -> {
            Stream.iterate ( 0 , i -> i + 1 )
                    .limit ( 10 ).forEach ( i -> map.put ( i , String.valueOf ( i +"t3") ) );
        } );
        t3.start ( );

        try {
            // Wait for all threads to finish
            t1.join ( );
            t2.join ( );
            t3.join ( );
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }

        // Now print the contents of the map
        map.forEach ( ( key , value ) -> System.out.println ( key + " : " + value ) );
    }
}
