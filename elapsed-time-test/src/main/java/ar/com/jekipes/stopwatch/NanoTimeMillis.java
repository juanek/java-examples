package ar.com.jekipes.stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * mvn exec:java -Dexec.mainClass="ar.com.jekipes.stopwatch.NanoTimeMillis"
 *
 * @author juan kipes
 */
public class NanoTimeMillis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException ex) {
            System.out.println("ex " + ex);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.format("Nanosegundos = %s, ( Inicio : %s, Fin : %s ) \n", duration, startTime, endTime);
        System.out.println("Formato legible (d HH:mm:ss.s) : " + nanoToShortDHMS(duration));

    }

    //modificar
    public static String nanoToShortDHMS(long duration) {
        String res;    // java.util.concurrent.TimeUnit;
        long days = TimeUnit.NANOSECONDS.toDays(duration);
        long hours = TimeUnit.NANOSECONDS.toHours(duration)
                - TimeUnit.DAYS.toHours(TimeUnit.NANOSECONDS.toDays(duration));
        long minutes = TimeUnit.NANOSECONDS.toMinutes(duration)
                - TimeUnit.HOURS.toMinutes(TimeUnit.NANOSECONDS.toHours(duration));
        long seconds = TimeUnit.NANOSECONDS.toSeconds(duration)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(duration));
        long millis = TimeUnit.NANOSECONDS.toMillis(duration)
                - TimeUnit.SECONDS.toMillis(TimeUnit.NANOSECONDS.toSeconds(duration));

        if (days == 0) {
            res = String.format("%02d:%02d:%02d.%04d", hours, minutes, seconds, millis);
        } else {
            res = String.format("%dd %02d:%02d:%02d.%04d", days, hours, minutes, seconds, millis);
        }
        return res;
    }

}
