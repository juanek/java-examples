package ar.com.juanek;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author juanekipes@gmail.com
 */
public class Calculator {
    private static final Integer DEFAULT_RANGE = 20;
    private final LocalDate birth;
    private final LocalDate target;
    private final Integer range;

    public static Calculator of(LocalDate birth) {
        return  new Calculator(birth);
    }

    private Calculator(LocalDate birth) {
        this.birth = birth;
        this.target = LocalDate.now();
        this.range = DEFAULT_RANGE;
    }

    private Map<Biorhythm,Double> executeCal(){
        Map<Biorhythm,Double> buffer = new HashMap<>();
        Arrays.stream(Biorhythm.values()).forEach(biorhythm -> {
            Duration duration = Duration.between(birth.atStartOfDay(),target.atStartOfDay());
            int period = biorhythm.getPeriod();
            long totalDays = duration.toDays();
            double result = Math.sin(2 * Math.PI * totalDays / period);
            buffer.put(biorhythm,result);
        });
        return buffer;
    }

    public Response calculate(){
        Objects.requireNonNull(birth);
        return Response.of(this.executeCal());
    }
}
