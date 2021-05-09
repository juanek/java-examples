package ar.com.juanek;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static org.assertj.core.api.Assertions.*;


public class MyAppTest {


    @Test
    public void myAppTest() {

        assertThat(true).isTrue();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime future = LocalDateTime.of(2021, Month.JULY, 3, 6, 30, 40);


        long distance = future.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        long diff = (distance - System.currentTimeMillis()) / 1000;


        assertThat(diff).isGreaterThan(0);

        int secs = (int) diff % 60;

        int mins = (int) (diff / 60) % 60;

        int hours = (int) (diff / (60 * 60)) % 24;

        int days = (int) (diff / (60 * 60 * 24));

        String countDown = String.format("Days %d Hours %d Min %d Secs %d", days, hours, mins, secs);

        System.out.println(countDown);

    }


    @Test
    public void givenUsingTimer_whenSchedulingTaskOnce_thenCorrect() throws InterruptedException {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on: " + new Date() + "n" +
                        "Thread's name: " + Thread.currentThread().getName());
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 1000L;

        timer.schedule(task, delay);
        //allow the Timer's thread to run the task
        Thread.sleep(delay * 2);
    }
}
