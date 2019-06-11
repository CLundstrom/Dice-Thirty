package controllers;

import models.Dice;
import models.Game;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 11/06/2019
 * <p>
 * @Description:
 */
public class GameController {

    private Game mGame;


    public void startGame(){
        mGame = new Game();

    }

    public void endGame(){

    }

    public void updateView(){
        for (Dice d: mGame.getDices()){
            int val = d.getValue();
        }
    }


}
