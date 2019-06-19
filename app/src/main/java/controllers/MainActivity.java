package controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.thirty.R;

import models.Score;

/**
 * @Author: Christoffer Lundstrom
 * @Date: 10/06/2019
 * <p>
 * @Description:
 */
public class MainActivity extends AppCompatActivity {

    Button newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newGame = findViewById(R.id.new_game);
        newGame.setOnClickListener((v) -> startActivity(new Intent(this, GameActivity.class)));

        // Testing
        Score score = new Score();
    }
}
