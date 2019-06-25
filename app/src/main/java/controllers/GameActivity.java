package controllers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thirty.R;
import com.example.thirty.Views.ScoreView;

import java.util.ArrayList;
import java.util.Arrays;

import models.Score;
import models.ScoreCalculator;


/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description: Represents the Screen viewed after initating a New Game.
 */
public class GameActivity extends AppCompatActivity {

    private GameController mGameController;
    private ArrayList<ImageView> mDiceViews;
    private Button mRollButton;
    private Button mCollectButton;
    private TextView mRollsRemainingText;
    private Spinner mScoreSelectionSpinner;
    private ScoreView mScoreView;
    private String mCurrentSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mRollButton = findViewById(R.id.button_roll);
        mCollectButton = findViewById(R.id.button_collect_score);
        mRollsRemainingText = findViewById(R.id.rolls);
        mScoreSelectionSpinner = findViewById(R.id.spinner);
        mScoreView = new ScoreView(findViewById(R.id.score_view));

        Resources resource = getResources();

        String[] scoreArray = resource.getStringArray(R.array.score_values);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                new ArrayList<>(Arrays.asList(scoreArray))
                );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mScoreSelectionSpinner.setAdapter(adapter);
        mScoreSelectionSpinner.setSelection(0);


        // Function
        mScoreSelectionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getSelectedItem().toString().equals("Low")){
                    mGameController
                            .getCurrentGame()
                            .getCurrentRound()
                            .updateRoundScore(new Score(
                                    ScoreCalculator.calcScoreLow(mGameController.getCurrentGame().getCurrentRound().getDices()),
                                    parent.getSelectedItem().toString()));

                    mGameController.getCurrentGame().getCurrentRound().getScore().setChoice(parent.getSelectedItem().toString());
                    mScoreView.updateViewWithScore(mGameController.getCurrentGame().getCurrentRound().getScore());
                }

                else if(parent.getSelectedItem().toString().equals("Pick a number..")){
                    // DO NOTHING.
                }
                else{
                    int selectedVal = Integer.valueOf((String)parent.getSelectedItem());
                    mGameController
                            .getCurrentGame()
                            .getCurrentRound()
                            .updateRoundScore(new Score(
                                    ScoreCalculator.calcScore(mGameController.getCurrentGame().getCurrentRound().getDices(), selectedVal),
                                    parent.getSelectedItem().toString()));

                    mGameController.getCurrentGame().getCurrentRound().getScore().setChoice(parent.getSelectedItem().toString());
                    mScoreView.updateViewWithScore(mGameController.getCurrentGame().getCurrentRound().getScore());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mRollButton.setOnClickListener(d -> {
            mGameController.refreshScene(this, mRollsRemainingText);
        });
        mCollectButton.setOnClickListener(d -> {
            String selectedItem = (String)mScoreSelectionSpinner.getSelectedItem();
            // Don't delete "Pick a number item"
            if(!selectedItem.equals("Pick a number..")){
                adapter.remove(selectedItem);
                adapter.notifyDataSetChanged();
                mScoreSelectionSpinner.setSelection(0);
                mGameController.getCurrentGame().nextRound();
                mGameController.refreshScene(this, mRollsRemainingText);
            }
        });

        mDiceViews = getDiceViews();
        mGameController = new GameController(mDiceViews, this);
    }

    /**
     * Fetches ImageViews from the Scene which are later manipulated by GameController.
     * @return
     */
    private ArrayList<ImageView> getDiceViews(){
            ArrayList<ImageView> views = new ArrayList<>();
            views.add((ImageView) findViewById(R.id.dice1));
            views.add((ImageView) findViewById(R.id.dice2));
            views.add((ImageView) findViewById(R.id.dice3));
            views.add((ImageView) findViewById(R.id.dice4));
            views.add((ImageView) findViewById(R.id.dice5));
            views.add((ImageView) findViewById(R.id.dice6));
            return views;
    }


    public void errorToast(){
        Toast.makeText(this, R.string.error_pick_number, Toast.LENGTH_SHORT).show();
    }
    /**
     * Starts the ScoreActivity.
     */
    public void nextActivity(){

        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("ScoreList", mGameController.getCurrentGame().getGameScores());
        startActivity(intent);
    }

}
