package controllers;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import models.Game;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 11/06/2019
 * <p>
 * @Description: Controls ImageViews, Click-listeners and updates scenes/frames.
 */
public class GameController {

    private final String STATE_GAMECONTROLLER = "STATE_GAMECONTROLLER";
    private GameActivity mGameActivityRef;
    private Game mGame;
    private ArrayList<ImageView> mImageViews;

    public GameController(ArrayList<ImageView> imageViews, GameActivity ref) {
        this.mImageViews = imageViews;
        mGameActivityRef = ref;
        mGame = new Game(this);
        updateImageView();
        attachListeners();
    }

    public Game getCurrentGame(){
        return this.mGame;
    }

    public void endGame(){
        mGameActivityRef.nextActivity();
    }


    /**
     * Updates the ImageViews to display the dices of the current round.
     */
    public void updateImageView() {
        for (int i = 0; i < mImageViews.size(); i++) {
            mImageViews.get(i).setImageResource(mGame.getCurrentRound().getDices().get(i).getCurrentImage());
        }
    }

    /**
     * Refreshes the Scene by providing a new toss of dices and Updating the View.
     *
     * @param context Is passed to a function which generates error messages for the provided Activity.
     * @param view TextObject to be updated with remaining amount of tosses left.
     */
    public void refreshScene(Context context, TextView view){
        mGame.getCurrentRound().tossDices(context);
        mGame.getCurrentRound().updateRollText(view);
        updateImageView();
    }

    /**
     * Initializing onClickListeners for the Dice ImageViews.
     *
     * TODO: Only update one dice instead of all when clicked. Working for now though.
     */
    private void attachListeners(){
        mImageViews.get(0).setOnClickListener( d -> {
            this.mGame.getCurrentRound().getDices().get(0).setMarked();
            updateImageView();
        });
        mImageViews.get(1).setOnClickListener( d -> {
            this.mGame.getCurrentRound().getDices().get(1).setMarked();
            updateImageView();
        });
        mImageViews.get(2).setOnClickListener( d -> {
            this.mGame.getCurrentRound().getDices().get(2).setMarked();
            updateImageView();
        });
        mImageViews.get(3).setOnClickListener( d -> {
            this.mGame.getCurrentRound().getDices().get(3).setMarked();
            updateImageView();
        });
        mImageViews.get(4).setOnClickListener( d -> {
            this.mGame.getCurrentRound().getDices().get(4).setMarked();
            updateImageView();
        });
        mImageViews.get(5).setOnClickListener( d -> {
            this.mGame.getCurrentRound().getDices().get(5).setMarked();
            updateImageView();
        });
    }
}
