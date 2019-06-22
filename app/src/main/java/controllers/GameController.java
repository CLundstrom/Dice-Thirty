package controllers;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import models.Dice;
import models.Game;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 11/06/2019
 * <p>
 * @Description: Controls ImageViews, Click-listeners and updates scenes/frames.
 */
public class GameController {


    private Game mGame;
    private ArrayList<ImageView> mImageViews;
    private ArrayList<Dice> mActiveDices;

    public GameController(ArrayList<ImageView> imageViews) {
        this.mImageViews = imageViews;
        mGame = new Game();
        mActiveDices = mGame.getCurrentRound().getDices();
        updateImageView();
        attachListeners();
    }


    /**
     * Updates the ImageViews to display the dices of the current round.
     */
    public void updateImageView() {
        List<Dice> dices = mGame.getCurrentRound().getDices();
        for (int i = 0; i < mImageViews.size(); i++) {
            mImageViews.get(i).setImageResource(dices.get(i).getCurrentImage());
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
            this.mActiveDices.get(0).setMarked();
            updateImageView();
        });
        mImageViews.get(1).setOnClickListener( d -> {
            this.mActiveDices.get(1).setMarked();
            updateImageView();
        });
        mImageViews.get(2).setOnClickListener( d -> {
            this.mActiveDices.get(2).setMarked();
            updateImageView();
        });
        mImageViews.get(3).setOnClickListener( d -> {
            this.mActiveDices.get(3).setMarked();
            updateImageView();
        });
        mImageViews.get(4).setOnClickListener( d -> {
            this.mActiveDices.get(4).setMarked();
            updateImageView();
        });
        mImageViews.get(5).setOnClickListener( d -> {
            this.mActiveDices.get(5).setMarked();
            updateImageView();
        });
    }
}
