package ar.com.jekipes.enums;

/**
 *
 * @author juan kipes
 */
public class Game {
    Result result;
    String message;
    int numTie;
    int numComputerWon;
    int numPlayerWon;
    int numTrials;

    public Game(Result result, String message,Params params) {
        this.result = result;
        this.message = message;
        this.numComputerWon = params.getNumComputerWon();
        this.numPlayerWon = params.getNumPlayerWon();
        this.numTie = params.getNumTie();
        this.numTrials = params.getNumTrials();
    }

    

    @Override
    public String toString() {
        return "\n***************************************************\n"+
                "  "+message+"\n"+
                "***************************************************\n";
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

    public int getNumTrials() {
        return numTrials;
    }
    
    
    

    
    
    

}
