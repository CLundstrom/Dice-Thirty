package models;

import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thirty.R;
import java.util.ArrayList;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description: Model for one Round in a Game of Thirty.
 */
public class GameRound {

    public final int AMOUNT_DICES = 6;
    private int mMaxRethrows;
    private ArrayList<Dice> mDices;
    private Score mScore;

    public GameRound(){
        mMaxRethrows = 2;
        mScore = new Score();
        mDices = generateDices(AMOUNT_DICES);
    }


    public ArrayList<Dice> getDices(){
        return mDices;
    }

    /**
     * Generates a new List of dices. Used for new GameRounds.
     * @return Returns a list of Randomized dices.
     */
    public ArrayList<Dice> generateDices(int diceAmount) {
        ArrayList<Dice> tmp = new ArrayList<>();
        for (int i = 0; i < diceAmount; i++) {
            tmp.add(new Dice());
        }
        return tmp;
    }

    public Score getScore() {
        return mScore;
    }

    /**
     * Updates the Rolls Left TextView.
     * @param view View to update.
     */
    public void updateRollText(TextView view){
        view.setText("Rolls left: " + mMaxRethrows);
    }


    /**
     * Sets current round score.
     * @param score Score to set.
     */
    public void setRoundScore(Score score){
        mScore = score;
    }

    /**
     * Provides new values for the dices. Used for each throw.
     */
    public void tossDices(Context context){
        if(isAttemptValid(context)){
            mMaxRethrows--;
            for (Dice d: mDices) {
                d.toss();
            }
        }
    }

    /**
     * @param context The context in which the Error Toast should appear.
     */
    private boolean isAttemptValid(Context context){
        if(mMaxRethrows > 0){
            return true;
        }
        else{
            Toast toast = Toast.makeText(context, R.string.out_of_attempts, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0,200);
            toast.show();
            return false;
        }
    }

}
