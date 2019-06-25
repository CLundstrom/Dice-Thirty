package models;

import java.io.Serializable;
import java.util.ArrayList;

import controllers.GameController;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description: Model for a Game of Thirty.
 */
public class Game {

    private static ArrayList<Score> mGameScores;
    private final int GAME_ROUNDS = 10;
    private int mRoundNr;
    private GameRound gameRound;
    private GameController mGameControllerRef;

    /**
     * A new game is Initialized and Default values are set.
     */
    public Game(GameController gameController) {
        mRoundNr = 1;
        mGameScores = new ArrayList<>();
        initializeGame();
        mGameControllerRef = gameController;
    }

    /**
     * Initializes a new GameRound.
     */
    private void initializeGame() {
        gameRound = new GameRound();
    }

    public void nextRound() {
        if (mRoundNr < GAME_ROUNDS) {
            mRoundNr++;
            mGameScores.add(gameRound.getScore());
            gameRound = new GameRound();
        } else {
            mGameControllerRef.endGame();
        }


    }

    public ArrayList<Score> getGameScores() {
        return mGameScores;
    }

    /**
     * @return Currently played round.
     */
    public GameRound getCurrentRound() {
        return gameRound;
    }
}
