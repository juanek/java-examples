package ar.com.jekipes.stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * mvn exec:java -Dexec.mainClass="ar.com.jekipes.stopwatch.CurrentTimeMillis"
 *
 * @author juan kipes
 */
public class CurrentTimeMillis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException ex) {
            System.out.println("ex " + ex);
        }
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.format("Milisegundos = %s, ( Inicio : %s, Fin : %s ) \n", duration, startTime, endTime);
        System.out.println("Formato legible (d HH:mm:ss.s) : " + millisToShortDHMS(duration));

    }

    public static String millisToShortDHMS(long duration) {
        String res;    // java.util.concurrent.TimeUnit;
        long days = TimeUnit.MILLISECONDS.toDays(duration);
        long hours = TimeUnit.MILLISECONDS.toHours(duration)
                - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
        long millis = TimeUnit.MILLISECONDS.toMillis(duration)
                - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(duration));

        if (days == 0) {
            res = String.format("%02d:%02d:%02d.%04d", hours, minutes, seconds, millis);
        } else {
            res = String.format("%dd %02d:%02d:%02d.%04d", days, hours, minutes, seconds, millis);
        }
        return res;
    }

}
