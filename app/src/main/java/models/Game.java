package models;

import java.util.ArrayList;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description: Model for a Game of Thirty.
 */
public class Game {

    private ArrayList<Integer> scores;
    private final int GAME_ROUNDS = 3;
    private int mRoundNr;
    private GameRound gameRound;

    /**
     * A new game is Initialized and Default values are set.
     */
    public Game() {
        mRoundNr = 0;

        initializeGame();

        // START SCORE ACTIVITY
    }

    private void initializeGame(){
        gameRound = new GameRound();
        //scores.add(gameRound.getScore());
    }

    public GameRound getCurrentRound(){
        return gameRound;
    }
}
