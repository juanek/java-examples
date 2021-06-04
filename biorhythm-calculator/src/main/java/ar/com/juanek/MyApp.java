package ar.com.juanek;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.temporal.TemporalUnit;
import java.util.function.BiConsumer;

/**
 * Biorhythm compatibility
 * sin(2πtT)
 * T=23(P), 28(E), 33(I)
 * t=base date−your birthday
 */

public class MyApp {
    private static final Logger LOG = LoggerFactory.getLogger(MyApp.class);

    public static void main(String[] args) {
        Response response = Calculator
                .of(LocalDate.of(1973, 02, 25))
                .calculate();
        response.getMaps().forEach((biorhythm, aDouble) -> System.out.println(biorhythm + " -> " + aDouble));

    }
}
