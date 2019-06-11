package models;

import java.nio.file.Path;
import java.util.Random;
/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description:
 */
public class Dice {

    private int mValue;
    private Path mImageUrl;
    private boolean mMarked;


    Dice(){
        toss(); // initial toss
        mMarked = false;
    }

    Dice(int value, boolean marked){
        this.mValue = value;
        this.mMarked = marked;
    }

    public int getValue(){
        return mValue;
    }

    public void toss(){
        this.mValue = new Random().nextInt(6) + 1; // 0-5 + 1
    }

    public void setMarked(){
        this.mMarked = true;
    }

    public boolean isMarked(){
        return mMarked;
    }

}
