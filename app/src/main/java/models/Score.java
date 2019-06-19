package models;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 17/06/2019
 * <p>
 * @Description:
 */
public class Score {

    private static final int SCORE_LOW = 4;
    ArrayList<Dice> mDice = new ArrayList<>();

    int mScore = 0;


    public Score() {
        mDice.add(new Dice(1, false));
        mDice.add(new Dice(1, false));
        mDice.add(new Dice(0, false));
        mDice.add(new Dice(0, false));
        mDice.add(new Dice(5, false));
        mDice.add(new Dice(6, false));

        int[] combo = convertDiceValueArray(mDice);


        calcScore(combo, 2);


        //findCombinationsOf(mDice, 5);
    }

    public int sumIntArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
        }
        return sum;
    }

    /**
     * Will find the unique combinations that a list of dices can
     * sum up to.
     *
     * @param number The sum we're looking for in the list of dices.
     */
    public void findCombinationsOf(ArrayList<Dice> dices, int number) {
        ArrayList<Dice> scores = new ArrayList<>();


        // Start with the first and second dice
        //combineDices(dices.get(0), 1, dices, number, scores);


        for (Dice d : scores) {
            Log.i("SCORES: ", String.valueOf(d.getValue()));
        }
    }


    /**
     * Converts all the values of a set of dices to an array.
     *
     * @param dices
     * @return
     */
    public int[] convertDiceValueArray(ArrayList<Dice> dices) {
        int tmpValue = 0;
        int score = 0;
        int sum = 0;

        int[] combos = new int[dices.size()];

        for (int i = 0; i < dices.size(); i++) {
            combos[i] = dices.get(i).getValue();
        }

        return combos;
    }


    public int calcScore(int[] combos, int findValue) {
        final int VALUE = findValue;
        int totalScore = 0;
        int currentSum = findValue;

        // Outer loop
        for (int i = 0; i < combos.length; i++) {

            currentSum = findValue; // reset counter

            for (int j = 0; j < combos.length - i; j++) {

                currentSum -= combos[i + j];

                // Value found
                if (currentSum == 0) {

                    // Add score and set dices used to 0;
                    for (int y = i; y <= i + j; y++) {
                        combos[y] = 0;
                    }
                    totalScore += findValue;
                    currentSum = findValue; // reset
                    i = 0; //reset outer loop
                    j = -1; //reset inner loop
                }
            }
        }
        System.out.println(totalScore);
        Log.d("SCORE:", String.valueOf(totalScore));
        return totalScore;
    }

    int calcScoreLow(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= SCORE_LOW) {
                sum += arr[i];
            }
        }
        return sum;
    }

    public int sumArr(ArrayList<Dice> dices) {
        int sum = 0;
        for (Dice d : dices) {
            sum += d.getValue();
        }
        return sum;
    }
}
