package ar.com.jekipes.enums;

/**
 *
 * @author juan kipes
 */
public class Params {

    private int numTie;
    private int numComputerWon;
    private int numPlayerWon;
    private int numTrials;

    public Params(int numTie, int numComputerWon, int numPlayerWon, int numTrials) {
        this.numTie = numTie;
        this.numComputerWon = numComputerWon;
        this.numPlayerWon = numPlayerWon;
        this.numTrials = numTrials;
    }

    public int getNumTie() {
        return numTie;
    }

    public int getNumComputerWon() {
        return numComputerWon;
    }

    public int getNumPlayerWon() {
        return numPlayerWon;
    }

    public void incrementParams(Result result) {
        incrementTrials();
        if (result.name().equals(Result.TIED.name())) {
            incrementNumTie();
        } else if (result.name().equals(Result.WIN.name())) {
            incrementComputerWon();
        } else {
            incrementPlayerWon();
        }
    }

    public int getNumTrials() {
        return numTrials;
    }

    private void incrementNumTie() {
        this.numTie++;
    }

    private void incrementPlayerWon() {
        this.numPlayerWon++;
    }

    private void incrementComputerWon() {
        this.numComputerWon++;
    }

    private void incrementTrials() {
        this.numTrials++;
    }
}
