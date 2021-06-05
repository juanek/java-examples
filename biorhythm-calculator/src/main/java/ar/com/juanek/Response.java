package ar.com.juanek;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author juanekipes@gmail.com
 */
public class Response {

    private final Map<Biorhythm, List<ResponseValueDay>> maps;

    private Response(Map<Biorhythm, List<ResponseValueDay>> maps) {
        this.maps = maps;
    }

    public Map<Biorhythm, List<ResponseValueDay>> getMaps() {
        return maps;
    }

    public static Response of(Map<Biorhythm, List<ResponseValueDay>> executeCal) {
        return new Response(executeCal);
    }

    static class ResponseValueDay{
        private final LocalDate day;
        private final Double value;

        public ResponseValueDay(LocalDate day, Double value) {
            this.day = day;
            this.value = value;
        }

        public LocalDate getDay() {
            return day;
        }

        public Double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "ResponseValueDay{" +
                    "day=" + day +
                    ", value=" + value +
                    '}';
        }
    }
}
