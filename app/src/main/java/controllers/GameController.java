package controllers;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import models.Dice;
import models.Game;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 11/06/2019
 * <p>
 * @Description: Controls the main flow of a Game.
 */
public class GameController {

    public final int AMOUNT_DICES = 6;
    private Game mGame;
    private ArrayList<ImageView> mImageViews;
    private ArrayList<Dice> mActiveDices;

    public GameController(ArrayList<ImageView> imageViews) {
        this.mImageViews = imageViews;
        mGame = new Game(AMOUNT_DICES);
        mActiveDices = mGame.getDices();
        updateImageView(this.mImageViews);
        attachListeners();
    }

    public void startGame() {
        mGame = new Game(AMOUNT_DICES);
    }

    public void endGame() {
    }

    public void updateImageView(ArrayList<ImageView> imageViews) {
        List<Dice> dices = mGame.getDices();
        for (int i = 0; i < imageViews.size(); i++) {
            imageViews.get(i).setImageResource(dices.get(i).getCurrentImage());
        }
    }

    public void updateImageView() {
        List<Dice> dices = mGame.getDices();
        for (int i = 0; i < mImageViews.size(); i++) {
            mImageViews.get(i).setImageResource(dices.get(i).getCurrentImage());
        }
    }

    public void markDice(ImageView view, int position) {
        List<Dice> tmp = mGame.getDices();
        tmp.get(position).setMarked();
    }

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
