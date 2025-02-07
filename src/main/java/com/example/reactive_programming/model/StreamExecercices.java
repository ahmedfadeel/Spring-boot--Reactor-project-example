package com.example.reactive_programming.model;

import java.util.stream.IntStream;

public class StreamExecercices {


     public static void printIntStream ( ) {
         StreamSource.getIntStream ().forEach( System.out::println );
     }
    public static void printIntStreamLessThanFive ( ) {
        StreamSource.getIntStream ()
                .filter( x -> x < 5 )
                .forEach( System.out::println );
    }
    public static void printSecondAndThirdNumberGreaterThanFive ( ) {
        StreamSource.getIntStream ()
                .filter( x -> x > 5 )
                .skip(1)
                .limit( 2 )
                .forEach( System.out::println );
    }
    public static void printFirstNumberGreaterThanFiveOrNegativeOne ( ) {
        StreamSource.getIntStream ()
                .filter( x -> x > 5 )
                .findFirst ()
                .ifPresentOrElse (
                        System.out::println ,
                        ()-> System.out.println (-1 ));

    }
    public static void printFistNamesInTheUserStream ( ) {
        StreamSource.getUserStream ()
                .forEach ( user-> System.out.println (user.firstName ) );



    }
    public static void printFistNamesInTheUserStreamThatHasIdsInIntStream ( ) {
        StreamSource.getUserStream ()
                .filter( user -> StreamSource.getIntStream ().anyMatch ( x -> x == user.id) )
                .forEach ( user-> System.out.println (user.firstName ) );
    }











    public static void main ( String[] args ) {
        printFistNamesInTheUserStreamThatHasIdsInIntStream ( );
    }


}
