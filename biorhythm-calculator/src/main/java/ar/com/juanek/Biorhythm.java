package ar.com.juanek;

/**
 * @author juanekipes@gmail.com
 */
public enum Biorhythm {
    Physical(23),Emotional(28), Intellectual(33);

    private int period;

    Biorhythm(int period) {
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }
}
