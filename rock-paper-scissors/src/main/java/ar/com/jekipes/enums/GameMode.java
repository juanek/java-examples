package ar.com.jekipes.enums;

import java.util.Random;

/**
 *
 * @author juan kipes
 */
public enum GameMode implements IGameMode {

    LEVEL_NOVICE {
        @Override
        public Game proccesGame(HandSign player, Params params) {
            HandSign computer = HandSign.values()[new Random().nextInt(HandSign.values().length)];
            HandSign.valueOf(computer.name()).show();
            return process(computer, player, params);

        }

    }, LEVEL_GOD {
        @Override
        public Game proccesGame(HandSign player, Params params) {
            HandSign computer = HandSign.ROCK;
            if(player.equals(HandSign.ROCK)){
                computer = HandSign.PAPER;
            }else if (player.equals(HandSign.PAPER)){
                computer = HandSign.SCISSORS;
            }
            HandSign.valueOf(computer.name()).show();
            return process(computer, player, params);
        }

    };

    protected Game process(HandSign computer, HandSign player, Params params) {
        String name = computer.name()+"_"+player.name();
        Permutations permutation = Permutations.getInstance(name);
        return new Game(permutation.getResult(),permutation.getMessage(), params);
    }

}
