package ar.com.juanek;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class CountDown {
    public static String of(LocalDateTime future) {
        long distance = future.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        long diff = (distance - System.currentTimeMillis()) / 1000;

        int secs = (int) diff % 60;
        int mins = (int) (diff / 60) % 60;
        int hours = (int) (diff / (60 * 60)) % 24;
        int days = (int) (diff / (60 * 60 * 24));

        String countDown = String.format("Days %d Hours %d Minutes %d Seconds %d", days, hours, mins, secs);

        return countDown;
    }
}
