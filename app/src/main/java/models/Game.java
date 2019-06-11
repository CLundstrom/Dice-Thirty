package models;

import android.media.Image;
import android.widget.ImageView;

import com.example.thirty.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description: Model for a Game of Thirty.
 */
public class Game {

    private static final int AMOUNT_DICES = 6;
    private int mRoundNr;
    private List<Dice> mDices = new ArrayList<>();
    private List<ImageView> mDicesView = new ArrayList<>();

    public Game() {
        mRoundNr = 0;
        mDices = generateDices();
    }

    /**
     * Initializes the games first round.
     * @return Returns a list of Randomized dices.
     */
    public ArrayList<Dice> generateDices() {
        ArrayList<Dice> tmp = new ArrayList<>();
        for (int i = 0; i < AMOUNT_DICES; i++) {
            tmp.add(new Dice());
        }
        return tmp;
    }

    public List<Dice> getDices(){
        return mDices;
    }
}
