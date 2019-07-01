package models;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description: Model for a Game of Thirty.
 */
public class Game implements Parcelable {



    private ArrayList<Score> mGameScores;
    public final int GAME_ROUNDS;
    private int mRoundNr;
    private GameRound mGameRound;

    /**
     * A new game is Initialized and Default values are set.
     */
    public Game() {
        mRoundNr = 1;
        GAME_ROUNDS = 10;
        mGameScores = new ArrayList<>();
        mGameRound = new GameRound();
    }

    /**
     * Game reinitialized with Parcelable.
     *
     * @param in Parcel
     */
    protected Game(Parcel in) {
        mGameScores = (ArrayList<Score>)in.readSerializable();
        GAME_ROUNDS = in.readInt();
        mRoundNr = in.readInt();
        mGameRound = in.readParcelable(GameRound.class.getClassLoader());
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    /**
     * Adds the current Round Score to the Game Score list.
     */
    private void saveScore() {
        mGameScores.add(mGameRound.getScore());
    }

    public boolean nextRound() {
        if (mRoundNr < GAME_ROUNDS) {
            mRoundNr++;
            saveScore();
            mGameRound = new GameRound();
            return false;
        } else {
            saveScore();
            return true;
        }
    }

    /**
     * Sets current round number of text-view.
     * @param view
     */
    public void setRoundNrText(TextView view){
        view.setText("Round: " + mRoundNr);
    }

    public int getRoundNr() {
        return mRoundNr;
    }

    /**
     * @return Score of the game.
     */
    public ArrayList<Score> getGameScores() {
        return mGameScores;
    }

    /**
     * @return Currently played round.
     */
    public GameRound getCurrentRound() {
        return mGameRound;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(mGameScores);
        dest.writeInt(GAME_ROUNDS);
        dest.writeInt(mRoundNr);
        dest.writeParcelable(mGameRound, 0);
    }
}
