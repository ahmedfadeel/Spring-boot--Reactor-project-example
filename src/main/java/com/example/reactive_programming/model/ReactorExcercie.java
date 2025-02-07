package com.example.reactive_programming.model;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class ReactorExcercie {


    public static  void printFlubString(){
        ReactiveSource.getStringFlux ().subscribe(new MySubscriber ());
    }




    public static void main ( String[] args ) throws IOException {
        printFlubString();

        System.out.println ("make any action " );
        System.in.read ();
    }


    static class MySubscriber<T> extends BaseSubscriber <T> {
       public void hookOnSubscribe ( Subscription subscription ) {
           System.out.println ( "hookOnSubscribe " );
           request ( 1 );
       }



       public void hookOnNext( T value ) {
           System.out.println ( "received " + value.toString ());
           request ( 1 );
       }


    }
}
