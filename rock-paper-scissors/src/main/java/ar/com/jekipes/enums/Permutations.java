package ar.com.jekipes.enums;

/**
 * Permutations {Computer,Player}
 *
 * @author juan kipes
 */
public enum Permutations {
    ROCK_ROCK, ROCK_PAPER, ROCK_SCISSORS,
    PAPER_ROCK, PAPER_PAPER, PAPER_SCISSORS,
    SCISSORS_ROCK, SCISSORS_PAPER, SCISSORS_SCISSORS;

    private final Result result;
    private final String message;

    private Permutations() {
        String[] computer_player = this.name().split("_");
        if (isTied(computer_player)) {
            result = Result.TIED;
            message = "Empate !";
        } else if (scissorWin(computer_player)) {
            result = Result.WIN;
            message = "Tijera corta papel, Tu pierdes!";
        } else if (paperWin(computer_player)) {
            result = Result.WIN;
            message = "Papel envuelve piedra, Tu pierdes!";
        } else if (rockWin(computer_player)) {
            result = Result.WIN;
            message = "Piedra rompe tijera, Tu pierdes!";
        } else {
            result = Result.LOST;
            message = "Tu ganas!";
        }
    }
    
    public static Permutations getInstance(String name){
        for(Permutations permutation:Permutations.values()){
            if(permutation.name().equals(name)){
                return permutation;
            }
        }
        throw new IllegalArgumentException("The "+name+" doesn't exist");
    }

    public Result getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    private static boolean isTied(String[] computer_player) {
        return computer_player[0].equals(computer_player[1]);
    }

    private static boolean rockWin(String[] computer_player) {
        return computer_player[0].equals(HandSign.ROCK.name()) && computer_player[1].equals(HandSign.SCISSORS.name());
    }

    private static boolean paperWin(String[] computer_player) {
        return computer_player[0].equals(HandSign.PAPER.name()) && computer_player[1].equals(HandSign.ROCK.name());
    }

    private static boolean scissorWin(String[] computer_player) {
        return computer_player[0].equals(HandSign.SCISSORS.name()) && computer_player[1].equals(HandSign.PAPER.name());
    }

}
