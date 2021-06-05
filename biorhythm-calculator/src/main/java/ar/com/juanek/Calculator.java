package ar.com.juanek;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author juanekipes@gmail.com
 */
public class Calculator {
    private static final Integer DEFAULT_RANGE = 20;
    private final LocalDate birth;
    private final LocalDate target;
    private final Integer range;

    public static Calculator of(LocalDate birth) {
        return new Calculator(birth);
    }

    private Calculator(LocalDate birth) {
        this.birth = birth;
        this.target = LocalDate.now();
        this.range = DEFAULT_RANGE;
    }

    private Map<Biorhythm, List<Response.ResponseValueDay>> executeCal() {
        LocalDate start = LocalDate.now().minusDays(range / 2);
        LocalDate end = LocalDate.now().plusDays(range / 2);
        List<LocalDate> dates = Stream
                .iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .collect(Collectors.toList());

        Map<Biorhythm, List<Response.ResponseValueDay>> buffer = new HashMap<>();
        dates.forEach(day -> Arrays.stream(Biorhythm.values()).forEach(biorhythm -> {
            Duration duration = Duration.between(day.atStartOfDay(), target.atStartOfDay());
            int period = biorhythm.getPeriod();
            long totalDays = duration.toDays();
            double result = Math.sin(2 * Math.PI * totalDays / period);
            putInBuffer(buffer, biorhythm, new Response.ResponseValueDay(day, result));
        }));
        return buffer;
    }

    private void putInBuffer(Map<Biorhythm, List<Response.ResponseValueDay>> buffer, Biorhythm biorhythm, Response.ResponseValueDay result) {
        buffer.computeIfAbsent(biorhythm, k -> new ArrayList<>()).add(result);
    }

    public Response calculate() {
        Objects.requireNonNull(birth);
        return Response.of(this.executeCal());
    }
}
