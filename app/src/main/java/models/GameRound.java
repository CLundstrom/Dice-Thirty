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
    public static final int MAX_RETHROWS = 3;
    private int mAttempt;
    private ArrayList<Dice> mDices;
    private int mScore;

    public GameRound(){
        mAttempt = 0;
        mScore = 0;
        mDices = generateDices(AMOUNT_DICES);
    }

    public int getScore() {
        return mScore;
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

    public void updateRollText(TextView view){
        view.setText("Rolls left: " + (MAX_RETHROWS-mAttempt));
    }


    /**
     * Provides new values for the dices. Used for each throw.
     */
    public void tossDices(Context context){
        if(isAttemptValid(context))
        for (Dice d: mDices) {
            d.toss();
        }
    }

    /**
     *
     * @param context The context in which the Toast should appear.
     */
    private boolean isAttemptValid(Context context){

        if(mAttempt < MAX_RETHROWS){
            mAttempt++;
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
