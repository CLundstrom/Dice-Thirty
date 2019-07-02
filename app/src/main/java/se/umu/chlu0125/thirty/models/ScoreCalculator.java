package se.umu.chlu0125.thirty.models;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: Christoffer Lundstrom
 * Date: 20/06/2019
 * <p>
 * Description: A class that calculates the Score of a dice combination.
 *
 * Uses an algorithm designed to find all Permutations of the Dices and compare all of them to
 * find the largest sum possible for the given value.
 */
public class ScoreCalculator {
    private static final int SCORE_LOW = 3;

    private static ArrayList<int[]> permutations = new ArrayList();
    private static ArrayList<Integer> score = new ArrayList<Integer>();

    public ScoreCalculator() {
    }


    /**
     * Converts all the values of a set of dices to an Integer array.
     *
     * @param dices Any number of dices.
     * @return Unsorted list of Dices values. Solely for Score Calculation.
     */
    private static int[] convertDiceValueArray(ArrayList<Dice> dices) {
        int[] combos = new int[dices.size()];

        for (int i = 0; i < dices.size(); i++) {
            combos[i] = dices.get(i).getValue();
        }
        return combos;
    }


    /**
     * Calculates the Score of the dices by iterating over an Integer array several passes so make sure
     * no score gets missed.
     * @param findValue
     * @return
     */
    public static int calcScore(ArrayList<Dice> dices, int findValue) {
        int[] combos = convertDiceValueArray(dices);
        permutations = new ArrayList<>();
        score = new ArrayList<>();

        findPermutations( 0,combos);
        for(int arr[] : permutations){
            compareArrays(arr, findValue);
        }

        int max = 0;
        for(int a : score){
            if(max < a) max = a;
        }

        return max;
    }

    /**
     * Finds all Permutations of the given Value-array.
     *
     * @param position Starting position of the array.
     * @param arr Array to Permutate.
     */
    public static void findPermutations(int position, int[] arr) {
        int[] array = Arrays.copyOf(arr, arr.length);
        if (position == array.length - 1) {
            permutations.add(array);
        }

        for (int i = position; i < array.length; i++) {
            int temp = array[position];
            array[position] = array[i];
            array[i] = temp;

            findPermutations(position + 1, array);

            array[i] = array[position];
            array[position] = temp;
        }
    }

    /**
     * Calculates the Score of the dices by iterating over an Integer array several passes so make sure
     * no score gets missed.
     * @param find
     */
    public static void compareArrays(int[] compare, int find) {
        int[] arr = Arrays.copyOfRange(compare, 0, compare.length);
        int totalScore = 0;

        // Outer loop
        for (int i = 0; i < arr.length; i++) {

            int currentSum = find; // Reset each pass

            for (int j = 0; j < arr.length - i; j++) {

                currentSum -= arr[i + j];

                if (currentSum < 0) continue;

                // Combination found
                if (currentSum == 0) {

                    // Sets dices used for calculation to 0;
                    for (int y = i; y <= i + j; y++) {
                        arr[y] = 0;
                    }
                    totalScore += find;
                    currentSum = find; // reset
                    i = 0; // Reset outer loop
                    j = -1; // Reset inner loop
                }
            }
        }
        score.add(totalScore);
    }


    /**
     * Calculates the Score when a user chooses Low score (special case).
     *
     * @return Returns the summarized score.
     */
    public static int calcScoreLow(ArrayList<Dice> dices) {

        int[] arr = convertDiceValueArray(dices);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= SCORE_LOW) {
                sum += arr[i];
            }
        }
        Log.d("SCORECALC", String.valueOf(sum));
        return sum;
    }

}
