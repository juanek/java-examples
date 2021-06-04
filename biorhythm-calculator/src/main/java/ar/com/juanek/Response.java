package ar.com.juanek;

import java.util.Map;

/**
 * @author juanekipes@gmail.com
 */
public class Response {

    private final Map<Biorhythm, Double> maps;

    private Response(Map<Biorhythm, Double> maps) {
        this.maps = maps;
    }

    public Map<Biorhythm, Double> getMaps() {
        return maps;
    }

    public static Response of(Map<Biorhythm, Double> executeCal) {
        return new Response(executeCal);
    }
}
