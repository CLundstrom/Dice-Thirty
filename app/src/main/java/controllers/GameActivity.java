package controllers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.thirty.R;
import com.example.thirty.Views.ScoreView;

import java.util.ArrayList;
import java.util.Arrays;

import models.Game;
import models.Score;
import models.ScoreCalculator;


/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description: Represents the Screen viewed after initiating a New Game.
 */
public class GameActivity extends AppCompatActivity {

    // PARCELS
    private final String STATE_GAME = "STATE_GAME";


    // CONTROLLERS
    private Game mGame;


    // VIEWS
    private Button mRollButton;
    private Button mCollectButton;
    private TextView mRollsRemainingText;
    private Spinner mScoreSelectionSpinner;
    private ScoreView mScoreView;
    private ArrayAdapter<String> mAdapter;
    private ArrayList<ImageView> mDiceViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (savedInstanceState != null) {
            this.mGame = savedInstanceState.getParcelable(STATE_GAME);
        } else {
            mGame = new Game();
        }

        findViewsAndAttachListeners();
        setupSpinner();
        getDiceViews();
        setDiceViewListeners();
        updateImageView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putParcelable(STATE_GAME, mGame);
        super.onSaveInstanceState(outState);
    }


    /**
     * Initializing onClickListeners for the Dice ImageViews.
     * <p>
     * TODO: Only update one dice instead of all when clicked. Working for now though.
     */
    private void setDiceViewListeners() {
        mDiceViews.get(0).setOnClickListener(d -> {
            this.mGame.getCurrentRound().getDices().get(0).setMarked();
            updateImageView();
        });
        mDiceViews.get(1).setOnClickListener(d -> {
            this.mGame.getCurrentRound().getDices().get(1).setMarked();
            updateImageView();
        });
        mDiceViews.get(2).setOnClickListener(d -> {
            this.mGame.getCurrentRound().getDices().get(2).setMarked();
            updateImageView();
        });
        mDiceViews.get(3).setOnClickListener(d -> {
            this.mGame.getCurrentRound().getDices().get(3).setMarked();
            updateImageView();
        });
        mDiceViews.get(4).setOnClickListener(d -> {
            this.mGame.getCurrentRound().getDices().get(4).setMarked();
            updateImageView();
        });
        mDiceViews.get(5).setOnClickListener(d -> {
            this.mGame.getCurrentRound().getDices().get(5).setMarked();
            updateImageView();
        });
    }


    /**
     * Setup of Spinner
     * <p>
     * Decides which functions to call based on 3 different selections. (Low, Other or Pick a number)
     */
    private void setupSpinner() {
        Resources resource = getResources();
        String[] scoreArray = resource.getStringArray(R.array.score_values);

        mAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                new ArrayList<>(Arrays.asList(scoreArray))
        );
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mScoreSelectionSpinner.setAdapter(mAdapter);
        mScoreSelectionSpinner.setSelection(0);


        mScoreSelectionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getSelectedItem().toString().equals("Low")) {
                    mGame
                            .getCurrentRound()
                            .setRoundScore(new Score(
                                    ScoreCalculator.calcScoreLow(mGame.getCurrentRound().getDices()),
                                    parent.getSelectedItem().toString()));

                    mGame.getCurrentRound().getScore().setChoice(parent.getSelectedItem().toString());
                    mScoreView.setScoreView(mGame.getCurrentRound().getScore());
                } else if (parent.getSelectedItem().toString().equals("Pick a number..")) {
                    // Do nothing
                } else {
                    int selectedVal = Integer.valueOf((String) parent.getSelectedItem());
                    mGame
                            .getCurrentRound()
                            .setRoundScore(new Score(
                                    ScoreCalculator.calcScore(mGame.getCurrentRound().getDices(), selectedVal),
                                    parent.getSelectedItem().toString()));

                    mGame.getCurrentRound().getScore().setChoice(parent.getSelectedItem().toString());
                    mScoreView.setScoreView(mGame.getCurrentRound().getScore());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    /**
     * Finds all relevant views and attaches button-listeners to those.
     */
    private void findViewsAndAttachListeners() {
        mRollButton = findViewById(R.id.button_roll);
        mCollectButton = findViewById(R.id.button_collect_score);
        mRollsRemainingText = findViewById(R.id.rolls);
        mScoreSelectionSpinner = findViewById(R.id.spinner);
        mScoreView = new ScoreView(findViewById(R.id.score_view));

        getDiceViews();

        /* Refreshes the Scene and resets selection.
         */
        mRollButton.setOnClickListener(d -> {
            refreshScene(this, mRollsRemainingText);
            mScoreView.setDefaultScoreView();
            mScoreSelectionSpinner.setSelection(0);
        });

        /*
         * Removes the used items from the Spinner and initiates next round.
         */
        mCollectButton.setOnClickListener(d -> {
            String selectedItem = (String) mScoreSelectionSpinner.getSelectedItem();
            // Don't delete "Pick a number item"
            if (!selectedItem.equals("Pick a number..")) {
                mAdapter.remove(selectedItem);
                mAdapter.notifyDataSetChanged();
                mScoreSelectionSpinner.setSelection(0);
                mGame.nextRound();
                mGame.getCurrentRound().resetDices();
                mGame.getCurrentRound().resetRollText(mRollsRemainingText);
                updateImageView();
                mScoreView.setDefaultScoreView();
            }
        });


    }

    /**
     * Fetches ImageViews from the Scene which are later manipulated by GameController.
     *
     * @return Returns a list of the Dice Views.
     */
    private void getDiceViews() {
        mDiceViews = new ArrayList<>();
        mDiceViews.add(findViewById(R.id.dice1));
        mDiceViews.add(findViewById(R.id.dice2));
        mDiceViews.add(findViewById(R.id.dice3));
        mDiceViews.add(findViewById(R.id.dice4));
        mDiceViews.add(findViewById(R.id.dice5));
        mDiceViews.add(findViewById(R.id.dice6));
    }

    /**
     * Starts the ScoreActivity.
     */
    public void nextActivity() {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("ScoreList", mGame.getGameScores());
        startActivity(intent);
    }

    /**
     * Updates the ImageViews to display the dices of the current round.
     */
    private void updateImageView() {
        for (int i = 0; i < mDiceViews.size(); i++) {
            mDiceViews.get(i).setImageResource(mGame.getCurrentRound().getDices().get(i).getCurrentImage());
        }
    }

    /**
     * Refreshes the Scene by providing a new toss of dices and Updating the View.
     *
     * @param context Is passed to a function which generates error messages for the provided Activity.
     * @param view    TextObject to be updated with remaining amount of tosses left.
     */
    public void refreshScene(Context context, TextView view) {
        mGame.getCurrentRound().tossDices(context);
        mGame.getCurrentRound().resetRollText(view);
        updateImageView();
    }
}
