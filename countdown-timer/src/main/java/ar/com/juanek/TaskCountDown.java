package ar.com.juanek;

import java.time.LocalDateTime;
import java.util.TimerTask;

public class TaskCountDown extends TimerTask {

    LocalDateTime future;

    public TaskCountDown(LocalDateTime future) {
        this.future = future;
    }

    @Override
    public void run() {
        System.out.print((char)13);
        System.out.print(CountDown.of(future));
    }
}
