package se.umu.chlu0125.thirty.models;

import se.umu.chlu0125.thirty.R;

import java.io.Serializable;
import java.util.Random;

/**
 * Author: Christoffer Lundstrom
 * Date: 10/06/2019
 * <p>
 * Description: Model for a Dice.
 */
public class Dice implements Serializable {

    private int mValue;
    private boolean mMarked;
    private int mCurrentImage;


    Dice() {
        toss(); // initial toss
        mMarked = false;
    }

    /**
     * @return Mark-state of a Dice.
     */
    public boolean isMarked() {
        return mMarked;
    }

    /**
     * @return Current value of Dice.
     */
    public int getValue() {
        return mValue;
    }

    /**
     * Tosses a Dice and selects the correct image for the dice.
     */
    public void toss() {
        if(mMarked == false){
            this.mValue = new Random().nextInt(6) + 1;
            switch (mValue) {
                case 1:
                    mCurrentImage = R.drawable.white1;
                    break;
                case 2:
                    mCurrentImage = R.drawable.white2;
                    break;
                case 3:
                    mCurrentImage = R.drawable.white3;
                    break;
                case 4:
                    mCurrentImage = R.drawable.white4;
                    break;
                case 5:
                    mCurrentImage = R.drawable.white5;
                    break;
                case 6:
                    mCurrentImage = R.drawable.white6;
                    break;
            }
        }
    }

    /**
     * Fetches the Image of the Dice.
     * @return Returns an R.id value of current image.
     */
    public int getCurrentImage() {
        return mCurrentImage;
    }


    /**
     * Marks or unmarks dices.
     * TODO: Find better solution than Switch-statement.
     */
    public void setMarked() {
        if(mMarked == false){
            mMarked = true;
            switch (mValue) {
                case 1:
                    mCurrentImage = R.drawable.grey1;
                    break;
                case 2:
                    mCurrentImage = R.drawable.grey2;
                    break;
                case 3:
                    mCurrentImage = R.drawable.grey3;
                    break;
                case 4:
                    mCurrentImage = R.drawable.grey4;
                    break;
                case 5:
                    mCurrentImage = R.drawable.grey5;
                    break;
                case 6:
                    mCurrentImage = R.drawable.grey6;
                    break;
            }
        }
        else {
            mMarked = false;
            switch (mValue) {
                case 1:
                    mCurrentImage = R.drawable.white1;
                    break;
                case 2:
                    mCurrentImage = R.drawable.white2;
                    break;
                case 3:
                    mCurrentImage = R.drawable.white3;
                    break;
                case 4:
                    mCurrentImage = R.drawable.white4;
                    break;
                case 5:
                    mCurrentImage = R.drawable.white5;
                    break;
                case 6:
                    mCurrentImage = R.drawable.white6;
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return String.valueOf(mValue);
    }
}
