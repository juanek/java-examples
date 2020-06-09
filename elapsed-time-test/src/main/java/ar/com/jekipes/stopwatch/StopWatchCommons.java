package ar.com.jekipes.stopwatch;

import org.apache.commons.lang3.time.StopWatch;

public class StopWatchCommons {

    public static void main(String[] args) throws InterruptedException {
        StopWatch clock = new StopWatch( );

        clock.start( );
        Thread.sleep(3500);
        clock.stop( );
        System.out.println( "Miliseconds= " + clock.getTime( ));

        clock.reset( );

        clock.start( );
        Thread.sleep(2500);
        clock.stop( );
        System.out.println( "Miliseconds= " + clock.getTime( ));

        clock.reset( );

        clock.start( );
        clock.split( );
        Thread.sleep(1000);
        System.out.println( "Primera vuelta: " + clock.getTime( ) );
        Thread.sleep(1000);
        System.out.println( "Segunda vuelta: " + clock.getTime( ) );
        clock.unsplit( );
        Thread.sleep(800);
        System.out.println( "Tiempo total: " + clock.getTime( ) );
    }
}
