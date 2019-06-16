package models;

import java.util.ArrayList;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description: Model for a Game of Thirty.
 */
public class Game {


    private int mRoundNr;
    private ArrayList<Dice> mDices = new ArrayList<>();
    private GameRound gameRound;

    /**
     * A new game is Initialized and Default values are set.
     */
    public Game(int diceAmount) {
        mRoundNr = 0;
        mDices = generateDices(diceAmount);
        gameRound = new GameRound();
    }

    /**
     * Generates a new List of dices. Used for each throw or new GameRound.
     * @return Returns a list of Randomized dices.
     */
    public ArrayList<Dice> generateDices(int diceAmount) {
        ArrayList<Dice> tmp = new ArrayList<>();
        for (int i = 0; i < diceAmount; i++) {
            tmp.add(new Dice());
        }
        return tmp;
    }

    /**
     * @return Returns the current set of Dices.
     */
    public ArrayList<Dice> getDices(){
        return mDices;
    }
}
