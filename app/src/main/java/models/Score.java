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
        mDice.add(new Dice(4,false));



        findCombinationsOf(mDice, 5);
    }




    public void findCombinationsOf(ArrayList<Dice> dices, int number){

        /**
         * index 4 dice + index 3 dice == 7
         *
         */


        // Base case (all dices checked)
        if(dices.size() == 0) return;
        ArrayList<Dice> scores = new ArrayList<>();
        for(Dice d: dices){
            // Each dice is the first. So all gets tested.
            combineDices(d, dices.size()-1, dices, number, scores);


        }

    }

    public ArrayList<Dice> combineDices(Dice startDice, int indexOfNextDice, ArrayList<Dice> dices, int number, ArrayList<Dice> scores){

        // Base case
        if(indexOfNextDice == 0){
            Log.i("MSG", "END OF RECURSION");
            return scores;
        }

        // If larger than value try with next dice.
        if (startDice.getValue()+dices.get(indexOfNextDice).getValue() > number){
            return combineDices(startDice, indexOfNextDice-1, dices, number, scores);
        }
        // If less than try to add another.
        else if(startDice.getValue()+dices.get(indexOfNextDice).getValue() < number){
            scores.add(startDice);
            return combineDices(dices.get(indexOfNextDice), indexOfNextDice-1, dices, number, scores);
        }
        else if (startDice.getValue()+dices.get(indexOfNextDice).getValue() == number){
            Log.i("MSG", String.format("%d %d", startDice.getValue(), dices.get(indexOfNextDice).getValue()));
            return scores;
        }

        throw new IndexOutOfBoundsException("There was an error.");
    }
}
