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

    ArrayList<Dice> mDice = new ArrayList<>();

    public Score(){
        mDice.add(new Dice(1,false));
        mDice.add(new Dice(2,false));
        mDice.add(new Dice(3,false));



        findCombinationsOf(mDice, 5);
    }


    /**
     * Will find the unique combinations that a list of dices can
     * sum up to.
     * @param number The sum we're looking for in the list of dices.
     */
    public void findCombinationsOf(ArrayList<Dice> dices, int number){
        ArrayList<Dice> scores = new ArrayList<>();

        // Start with the first and the last dice.
        combineDices(dices.get(0),1, dices, number, scores);


        for(Dice d: scores){
            Log.i("SCORES: ", String.valueOf(d.getValue()));
        }
    }

    /**
     * Recursive function that will combine all the dices in a list and
     * save those that match the given value and save them in a new list.
     *
     * @param currentDice
     * @param indexOfNextDice
     * @param dices
     * @param number
     * @param scores
     * @return
     */
    public ArrayList<Dice> combineDices(Dice currentDice, int indexOfNextDice, ArrayList<Dice> dices, int number, ArrayList<Dice> scores){

        // Base case
        if(indexOfNextDice == dices.size()){
            Log.i("MSG", "END OF RECURSION");
            return null;
        }

        // A sum is found

        // First dice and the value of the next dice is one pair.
        if (currentDice.getValue() == number){
            scores.add(currentDice);
            return scores;
        }

        // If larger than value skip dice and try combining the next dice.
        else if (currentDice.getValue() > number){
            return combineDices(dices.get(indexOfNextDice), indexOfNextDice+1, dices, number, scores);
        }

        // If sum less than number try to add another.
        else if(currentDice.getValue() < number){
            scores.add(currentDice);
            return combineDices(dices.get(indexOfNextDice),indexOfNextDice+1, dices, number, scores);
        }

        scores = new ArrayList<>();

        throw new RuntimeException("There was an unexpected error.");
    }

    public int sumArr(ArrayList<Dice> dices){
        int sum = 0;
        for (Dice d: dices){
            sum += d.getValue();
        }
        return sum;
    }
}
