package ar.com.jekipes.stopwatch;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

/**
 *  mvn -q exec:java -Dexec.mainClass="ar.com.jekipes.stopwatch.InstantTime"
 */
public class InstantTime {
    public static void main(String[] args) throws InterruptedException {

        Instant oneInstant = Instant.now();
        System.out.println(oneInstant);

        Instant anotherInstant = Instant.now(Clock.system(ZoneId.of("America/Argentina/Buenos_Aires")));
        System.out.println(anotherInstant);

        Instant startTime = Instant.now();
        Thread.sleep(3500);
        Instant endTime = Instant.now();
        System.out.println(Duration.between(startTime, endTime));
        System.out.println(Duration.between(startTime, endTime).toMillis());
        System.out.println(Duration.between(startTime, endTime).toNanos());

    }
}
