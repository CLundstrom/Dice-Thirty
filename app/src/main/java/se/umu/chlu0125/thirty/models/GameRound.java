package se.umu.chlu0125.thirty.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import se.umu.chlu0125.thirty.R;

import java.util.ArrayList;

/**
 * Author: Christoffer Lundstrom
 * Date: 10/06/2019
 * <p>
 * Description: Model for one Round in a Game of Thirty.
 */
public class GameRound implements Parcelable {

    public  int AMOUNT_DICES;
    private int mMaxRethrows;
    private ArrayList<Dice> mDices;
    private Score mScore;

    public GameRound() {
        mMaxRethrows = 2;
        AMOUNT_DICES = 6;
        mScore = new Score();
        mDices = generateDices(AMOUNT_DICES);
    }

    protected GameRound(Parcel in) {
        AMOUNT_DICES = in.readInt();
        mMaxRethrows = in.readInt();
        mDices = (ArrayList<Dice>)in.readSerializable();
        mScore = (Score) in.readSerializable();
    }

    public static final Creator<GameRound> CREATOR = new Creator<GameRound>() {
        @Override
        public GameRound createFromParcel(Parcel in) {
            return new GameRound(in);
        }

        @Override
        public GameRound[] newArray(int size) {
            return new GameRound[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(AMOUNT_DICES);
        dest.writeInt(mMaxRethrows);
        dest.writeSerializable(mDices);
        dest.writeSerializable(mScore);
    }

    public ArrayList<Dice> getDices() {
        return mDices;
    }

    /**
     * Generates a new List of dices. Used for new GameRounds.
     *
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
     *
     * @param view View to update.
     */
    public void updateRollsText(TextView view) {
        view.setText("Rolls left: " + mMaxRethrows);
    }


    /**
     * Sets current round score.
     *
     * @param score Score to set.
     */
    public void setRoundScore(Score score) {
        mScore = score;
    }

    /**
     * Provides new values for the dices. Used for each throw.
     */
    public void tossDices(Context context) {
        if(isAttemptValid(context)){
            for (Dice d : mDices) {
                d.toss();
            }
        }
    }

    public void resetDices(){
        for (Dice d : mDices) {
            d.toss();
        }
    }

    /**
     * Makes sure the user don't exceed maximum rerolls.
     *
     * @param context The context in which the Error Toast should appear.
     */
    private boolean isAttemptValid(Context context) {
        if (mMaxRethrows > 0) {
            mMaxRethrows--;
            return true;
        } else {
            Toast toast = Toast.makeText(context, R.string.out_of_attempts, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 200);
            toast.show();
            return false;
        }
    }


}
