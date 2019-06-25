package models;

import java.io.Serializable;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 17/06/2019
 * <p>
 * @Description: A class that handles Scoring of Dice-Tosses.
 */
public class Score implements Serializable {

    private static final int SCORE_LOW = 3;
    private int mScore = 0;

    public Score(){}

    public Score(int score) {
        mScore = score;
    }

    public int getScore(){
        return mScore;
    }
    public void setScore(int score){
        mScore = score;
    }

}
