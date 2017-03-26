package com.example.android.musictheoryquizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by dts on 26/03/17.
 */

public class StartPage extends AppCompatActivity {

    String playerName = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);
    }

    public void startGame(View v) {

        EditText playerNameField = (EditText) findViewById(R.id.player_name_field);
        playerName = playerNameField.getText().toString();

        if (playerNameField != null) {
            playerName = playerNameField.getText().toString();
        }
        if (playerName == null || playerName.length() == 0) {
            playerName = "";
        }

        Intent startQuizz = new Intent(StartPage.this, MainActivity.class);
        startQuizz.putExtra("PLAYER_NAME", playerName);
        startActivity(startQuizz);

        /*
        TextView playerNameMain = (TextView) findViewById(R.id.player_name);
        playerNameMain.setText(playerName);
        */
    }
}
