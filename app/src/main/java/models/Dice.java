package models;

import com.example.thirty.R;

import java.util.Random;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description: Model for a Dice.
 */
public class Dice {

    private int mValue;
    private boolean mMarked;
    private int mCurrentImage;


    Dice() {
        toss(); // initial toss
        mMarked = false;
    }

    Dice(int value, boolean marked) {
        this.mValue = value;
        this.mMarked = marked;
    }

    public int getValue() {
        return mValue;
    }

    public void toss() {
        this.mValue = new Random().nextInt(6) + 1;

        // Updates currentImage to the corresponding value of the dice.
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

    public int getCurrentImage() {
        return mCurrentImage;
    }


    /**
     * Marks or unmarks dices.
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

    public boolean isMarked() {
        return mMarked;
    }

}
