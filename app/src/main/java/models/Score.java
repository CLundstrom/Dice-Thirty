package models;

import android.util.Log;

import java.util.ArrayList;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 17/06/2019
 * <p>
 * @Description: A class that handles Scoring of Dice-Tosses.
 */
public class Score {

    private static final int SCORE_LOW = 4;
    ArrayList<Dice> mDice = new ArrayList<>();
    int mScore = 0;


    public Score() {
        mDice.add(new Dice(6, false));
        mDice.add(new Dice(6, false));
        mDice.add(new Dice(6, false));
        mDice.add(new Dice(6, false));
        mDice.add(new Dice(6, false));
        mDice.add(new Dice(6, false));

        int[] combo = convertDiceValueArray(mDice);
        calcScore(combo, 12);
    }


    public int getScore(){
        return mScore;
    }

    /**
     * Converts all the values of a set of dices to an Integer array.
     *
     * @param dices Any number of dices.
     * @return Unsorted list of Dices values. Solely for score Calculation.
     */
    private int[] convertDiceValueArray(ArrayList<Dice> dices) {
        int tmpValue = 0;
        int score = 0;
        int sum = 0;

        int[] combos = new int[dices.size()];

        for (int i = 0; i < dices.size(); i++) {
            combos[i] = dices.get(i).getValue();
        }
        return combos;
    }


    /**
     * Calculates the Score of the dices by iterating over an Integer array several passes so make sure
     * no score gets missed.
     *
     * @param combos
     * @param findValue
     * @return
     */
    private int calcScore(int[] combos, int findValue) {
        int totalScore = 0;

        // Outer loop
        for (int i = 0; i < combos.length; i++) {

            int currentSum = findValue; // Reset each pass

            for (int j = 0; j < combos.length - i; j++) {

                currentSum -= combos[i + j];

                // Combination found
                if (currentSum == 0) {
                    // Sets dices used for calculation to 0;
                    for (int y = i; y <= i + j; y++) {
                        combos[y] = 0;
                    }
                    totalScore += findValue;
                    currentSum = findValue; // reset
                    i = 0; // Reset outer loop
                    j = -1; // Reset inner loop
                }
            }
        }
        Log.d("SCORE:", String.valueOf(totalScore));
        return totalScore;
    }

    /**
     * Calculates the Score when a user chooses Low score.
     *
     * @param arr Takes an array of Integers.
     * @return Returns the summarized score.
     */
    private int calcScoreLow(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= SCORE_LOW) {
                sum += arr[i];
            }
        }
        return sum;
    }
}
