package com.example.android.musictheoryquizzapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.musictheoryquizzapp.R.layout.start_layout;

public class MainActivity extends AppCompatActivity {

    String playerName = "";
    int helpCount = 0;
    String[] usedHelps = new String[3];
    String[] usedHelpsIcon = new String[3];
    boolean[] isTipOn = new boolean[8];
    boolean[] isFiftyOn = new boolean[6];
    int[] fiftyAbleQuestions = {
            1,
            2,
            3,
            4,
            6
    };
    String mLayout = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            if (savedInstanceState.getString("LAYOUT_KEY").contentEquals("activity_main")) {
                setContentView(R.layout.activity_main);
            } else {
                setContentView(start_layout);
            }
        } else {
            setContentView(start_layout);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("LAYOUT_KEY", mLayout);
        outState.putString("PLAYER_NAME_KEY", playerName);

        if (mLayout.contentEquals("activity_main")) {

            outState.putStringArray("USED_HELPS_ARRAY_KEY", usedHelps);
            outState.putStringArray("HELPS_ICON_ARRAY_KEY", usedHelpsIcon);
            outState.putInt("HELP_COUNT", helpCount);
            outState.putBooleanArray("USED_HINTS_ARRAY_KEY", isTipOn);
            outState.putBooleanArray("USED_FIFTY_ARRAY_KEY", isFiftyOn);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.getString("LAYOUT_KEY").contentEquals("activity_main")) {

            TextView mPlayerName = (TextView) findViewById(R.id.player_name);
            playerName = savedInstanceState.getString("PLAYER_NAME_KEY");
            mPlayerName.setText(String.valueOf(savedInstanceState.getString("PLAYER_NAME_KEY")));
            helpCount = savedInstanceState.getInt("HELP_COUNT");
            mLayout = savedInstanceState.getString("LAYOUT_KEY");
            usedHelps = savedInstanceState.getStringArray("USED_HELPS_ARRAY_KEY");
            usedHelpsIcon = savedInstanceState.getStringArray("HELPS_ICON_ARRAY_KEY");
            isTipOn = savedInstanceState.getBooleanArray("USED_HINTS_ARRAY_KEY");
            isFiftyOn = savedInstanceState.getBooleanArray("USED_FIFTY_ARRAY_KEY");

            if (usedHelps[0] != null) {
                for (int i = 0; i < (helpCount); i++) {
                    int helpResId = getResources().getIdentifier(usedHelps[i], "id", getPackageName());
                    int srcResId = getResources().getIdentifier(usedHelpsIcon[i], "id", getPackageName());
                    ImageView helpIcon = (ImageView) findViewById(helpResId);
                    helpIcon.setImageResource(srcResId);
                }
                for (int i = 0; i < helpCount; i++) {
                    int helpCountResId = getResources().getIdentifier("help" + (i + 1), "id", getPackageName());
                    ImageView helpCountIcon = (ImageView) findViewById(helpCountResId);
                    helpCountIcon.setImageResource(R.drawable.icon_help_wh);
                }
            }
            for (int i = 0; i < (8); i++) {
                if (isTipOn[i] == true) {
                    displayHint(i + 1);
                }
            }

            isFiftyOn[4] = false;
            for (int j = 0; j < (6); j++) {
                if (isFiftyOn[j] == true) {
                    // int fiftyQuestion = fiftyAbleQuestions[j];
                    displayFifty(j + 1);
                }
            }
            if (helpCount == 3) {
                fullHelpWipe();
            }

        }
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

        mLayout = "activity_main";
        setContentView(R.layout.activity_main);
        TextView playerNameMain = (TextView) findViewById(R.id.player_name);
        playerNameMain.setText(playerName);
    }

    public void buttonLogic3A(View v) {
        RadioButton q3B = (RadioButton) findViewById(R.id.radio_3B);
        RadioButton q3C = (RadioButton) findViewById(R.id.radio_3C);
        RadioButton q3D = (RadioButton) findViewById(R.id.radio_3D);

        q3B.setChecked(false);
        q3C.setChecked(false);
        q3D.setChecked(false);
    }

    public void buttonLogic3B(View v) {
        RadioButton q3A = (RadioButton) findViewById(R.id.radio_3A);
        RadioButton q3C = (RadioButton) findViewById(R.id.radio_3C);
        RadioButton q3D = (RadioButton) findViewById(R.id.radio_3D);

        q3A.setChecked(false);
        q3C.setChecked(false);
        q3D.setChecked(false);
    }

    public void buttonLogic3C(View v) {
        RadioButton q3B = (RadioButton) findViewById(R.id.radio_3B);
        RadioButton q3A = (RadioButton) findViewById(R.id.radio_3A);
        RadioButton q3D = (RadioButton) findViewById(R.id.radio_3D);

        q3B.setChecked(false);
        q3A.setChecked(false);
        q3D.setChecked(false);
    }

    public void buttonLogic3D(View v) {
        RadioButton q3B = (RadioButton) findViewById(R.id.radio_3B);
        RadioButton q3C = (RadioButton) findViewById(R.id.radio_3C);
        RadioButton q3A = (RadioButton) findViewById(R.id.radio_3A);

        q3B.setChecked(false);
        q3C.setChecked(false);
        q3A.setChecked(false);
    }

    public void buttonLogic4A(View v) {
        RadioButton q4B = (RadioButton) findViewById(R.id.radio_4B);
        RadioButton q4C = (RadioButton) findViewById(R.id.radio_4C);
        RadioButton q4D = (RadioButton) findViewById(R.id.radio_4D);

        q4B.setChecked(false);
        q4C.setChecked(false);
        q4D.setChecked(false);
    }

    public void buttonLogic4B(View v) {
        RadioButton q4A = (RadioButton) findViewById(R.id.radio_4A);
        RadioButton q4C = (RadioButton) findViewById(R.id.radio_4C);
        RadioButton q4D = (RadioButton) findViewById(R.id.radio_4D);

        q4A.setChecked(false);
        q4C.setChecked(false);
        q4D.setChecked(false);
    }

    public void buttonLogic4C(View v) {
        RadioButton q4B = (RadioButton) findViewById(R.id.radio_4B);
        RadioButton q4A = (RadioButton) findViewById(R.id.radio_4A);
        RadioButton q4D = (RadioButton) findViewById(R.id.radio_4D);

        q4B.setChecked(false);
        q4A.setChecked(false);
        q4D.setChecked(false);
    }

    public void buttonLogic4D(View v) {
        RadioButton q4B = (RadioButton) findViewById(R.id.radio_4B);
        RadioButton q4C = (RadioButton) findViewById(R.id.radio_4C);
        RadioButton q4A = (RadioButton) findViewById(R.id.radio_4A);

        q4B.setChecked(false);
        q4C.setChecked(false);
        q4A.setChecked(false);
    }

    public void buttonLogic6A(View v) {
        RadioButton q6B = (RadioButton) findViewById(R.id.radio_6B);
        RadioButton q6C = (RadioButton) findViewById(R.id.radio_6C);
        RadioButton q6D = (RadioButton) findViewById(R.id.radio_6D);

        q6B.setChecked(false);
        q6C.setChecked(false);
        q6D.setChecked(false);
    }

    public void buttonLogic6B(View v) {
        RadioButton q6A = (RadioButton) findViewById(R.id.radio_6A);
        RadioButton q6C = (RadioButton) findViewById(R.id.radio_6C);
        RadioButton q6D = (RadioButton) findViewById(R.id.radio_6D);

        q6A.setChecked(false);
        q6C.setChecked(false);
        q6D.setChecked(false);
    }

    public void buttonLogic6C(View v) {
        RadioButton q6B = (RadioButton) findViewById(R.id.radio_6B);
        RadioButton q6A = (RadioButton) findViewById(R.id.radio_6A);
        RadioButton q6D = (RadioButton) findViewById(R.id.radio_6D);

        q6B.setChecked(false);
        q6A.setChecked(false);
        q6D.setChecked(false);
    }

    public void buttonLogic6D(View v) {
        RadioButton q6B = (RadioButton) findViewById(R.id.radio_6B);
        RadioButton q6C = (RadioButton) findViewById(R.id.radio_6C);
        RadioButton q6A = (RadioButton) findViewById(R.id.radio_6A);

        q6B.setChecked(false);
        q6C.setChecked(false);
        q6A.setChecked(false);
    }

    public void audioPlayback(View v) {
        MediaPlayer chordPlayback = MediaPlayer.create(this, R.raw.d_dim_chord);
        chordPlayback.start();
    }

    public void calculateScore(View v) {
        int score = 0;
        int answer1Point = R.id.radio_1B;
        int answer2Point = R.id.radio_2C;
        int answer3Point = R.id.radio_3B;
        int answer4Point = R.id.radio_4C;
        int answer5aPoint = R.id.checkbox_5C;
        int answer5bPoint = R.id.checkbox_5D;
        int answer6Point = R.id.radio_6D;
        int answer7aPoint = R.id.checkbox_7A;
        int answer7bPoint = R.id.checkbox_7D;
        String[] answer8Point = {
                "harmonic",
                "harmonic minor",
                "minor harmonic"
        };

        boolean answer1 = ((RadioButton) findViewById(answer1Point)).isChecked();
        boolean answer2 = ((RadioButton) findViewById(answer2Point)).isChecked();
        boolean answer3 = ((RadioButton) findViewById(answer3Point)).isChecked();
        boolean answer4 = ((RadioButton) findViewById(answer4Point)).isChecked();
        boolean answer5a = ((CheckBox) findViewById(answer5aPoint)).isChecked();
        boolean answer5b = ((CheckBox) findViewById(answer5bPoint)).isChecked();
        boolean answer5x = ((CheckBox) findViewById(R.id.checkbox_5A)).isChecked();
        boolean answer5y = ((CheckBox) findViewById(R.id.checkbox_5B)).isChecked();
        boolean answer6 = ((RadioButton) findViewById(answer6Point)).isChecked();
        boolean answer7a = ((CheckBox) findViewById(answer7aPoint)).isChecked();
        boolean answer7b = ((CheckBox) findViewById(answer7bPoint)).isChecked();
        boolean answer7x = ((CheckBox) findViewById(R.id.checkbox_7B)).isChecked();
        boolean answer7y = ((CheckBox) findViewById(R.id.checkbox_7C)).isChecked();
        String answer8 = ((EditText) findViewById(R.id.text_field_8)).getText().toString();

        for (int i = 0; i < (answer8Point.length); i++) {
            if (answer8.equalsIgnoreCase(answer8Point[i])) {
                score += 2;
            }
        }

        if (answer1 == true) {
            score += 2;
        }
        if (answer2 == true) {
            score += 2;
        }
        if (answer3 == true) {
            score += 2;
        }
        if (answer4 == true) {
            score += 2;
        }
        if (answer5a == true) {
            score += 1;
        }
        if (answer5b == true) {
            score += 1;
        }
        if (answer5x == true) {
            score -= 1;
        }
        if (answer5y == true) {
            score -= 1;
        }
        if (answer6 == true) {
            score += 2;
        }
        if (answer7a == true) {
            score += 1;
        }
        if (answer7b == true) {
            score += 1;
        }
        if (answer7x == true) {
            score -= 1;
        }
        if (answer7y == true) {
            score -= 1;
        }

        score -= helpCount;
        if (score < 0) {
            score = 0;
        }

        Log.i("MainActivity", "Score is " + score);

        if (playerName != "") {
            Toast toast = Toast.makeText(this, playerName + ", you scored " + score + "/16", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "You scored " + score + "/16", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void giveHint(View v) {
        int questionNo = 0;

        switch (v.getId()) {
            case R.id.q1_hint:
                questionNo = 1;
                break;
            case R.id.q2_hint:
                questionNo = 2;
                break;
            case R.id.q3_hint:
                questionNo = 3;
                break;
            case R.id.q4_hint:
                questionNo = 4;
                break;
            case R.id.q5_hint:
                questionNo = 5;
                break;
            case R.id.q6_hint:
                questionNo = 6;
                break;
            case R.id.q7_hint:
                questionNo = 7;
                break;
            case R.id.q8_hint:
                questionNo = 8;
                break;
        }

        helpCount += 1;
        if (helpCount < 4) {

            displayHint(questionNo);
            deleteHelps(questionNo, "hint");

        } else {
            helpCount = 3;
            Toast toast = Toast.makeText(this, "No more helps available", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void displayHint(int questionNo) {

        String[] hints = {
                "Do, Re, Mi, Fa... is a diatonic scale.",
                "The circle of 5ths goes like: G, D, A...",
                "A major chord is made of a Major 3rd and a minor 3rd on top.",
                "4ths, 5ths and 8ths are not major.",
                "Relatives are a minor 3rd away.",
                "Minor and diminished chords sound dark.",
                "Half-Diminished chords are made of a minor 3rd, diminished 5th and minor 7th.",
                "It's a minor scale with sharp 7th."
        };

        String hintText = hints[(questionNo - 1)];

        String questionHintResId = "hint" + (questionNo);
        int hintResId = getResources().getIdentifier(questionHintResId, "id", getPackageName());
        TextView questionHintText = (TextView) findViewById(hintResId);
        questionHintText.setText("" + hintText);
    }

    public void deleteHelps(int questionNo, String type) {


        //  Find out which help view was used
        String helpViewResId = "q" + (questionNo) + "_" + (type);
        int helpResId = getResources().getIdentifier(helpViewResId, "id", getPackageName());
        ImageView helpIcon = (ImageView) findViewById(helpResId);
        //  Defining the resource of the "del" icon
        String iconViewResId = "@drawable/icon_" + (type) + "_del";
        int iconResId = getResources().getIdentifier(iconViewResId, "id", getPackageName());
        helpIcon.setImageResource(iconResId);
        //  Changing the help counting icons
        int helpCountResId = getResources().getIdentifier("help" + helpCount, "id", getPackageName());
        ImageView helpCountIcon = (ImageView) findViewById(helpCountResId);
        helpCountIcon.setImageResource(R.drawable.icon_help_wh);

        // Used helps array jazz for onRestore()
        if (helpCount < 4) {
            usedHelps[helpCount - 1] = helpViewResId;
            usedHelpsIcon[helpCount - 1] = iconViewResId;
        }

        if (type.equals("hint")) {
            isTipOn[questionNo - 1] = true;
        } else {
            isFiftyOn[questionNo - 1] = true;
        }


        if (helpCount == 3) {
            fullHelpWipe();
        }
    }

    // When no more helps are available
    public void fullHelpWipe() {
        for (int i = 1; i < 9; i++) {
            String helpViewResId = "q" + (i) + "_hint";
            int helpResId = getResources().getIdentifier(helpViewResId, "id", getPackageName());
            ImageView hintIcon = (ImageView) findViewById(helpResId);
            hintIcon.setImageResource(R.drawable.icon_hint_del);
        }

        for (int i = 0; i < (fiftyAbleQuestions.length); i++) {
            String helpViewResId = "q" + (fiftyAbleQuestions[i]) + "_fifty";
            int helpResId = getResources().getIdentifier(helpViewResId, "id", getPackageName());
            ImageView fiftyIcon = (ImageView) findViewById(helpResId);
            String iconViewResId = "@drawable/icon_fifty_del";
            int iconResId = getResources().getIdentifier(iconViewResId, "id", getPackageName());
            fiftyIcon.setImageResource(iconResId);
        }
    }


    public void give50(View v) {
        int questionNo = 0;

        switch (v.getId()) {
            case R.id.q1_fifty:
                questionNo = 1;
                break;
            case R.id.q2_fifty:
                questionNo = 2;
                break;
            case R.id.q3_fifty:
                questionNo = 3;
                break;
            case R.id.q4_fifty:
                questionNo = 4;
                break;
            case R.id.q6_fifty:
                questionNo = 6;
                break;

        }

        helpCount += 1;

        if (helpCount < 4) {
            deleteHelps(questionNo, "fifty");
            displayFifty(questionNo);

        } else {
            helpCount = 3;
            Toast toast = Toast.makeText(this, "No more helps available", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void displayFifty(int questionNo) {
        switch (questionNo) {
            case 1:
                RadioButton radioOut1a = (RadioButton) findViewById(R.id.radio_1A);
                radioOut1a.setVisibility(View.INVISIBLE);
                RadioButton radioOut1b = (RadioButton) findViewById(R.id.radio_1D);
                radioOut1b.setVisibility(View.INVISIBLE);
                break;
            case 2:
                RadioButton radioOut2a = (RadioButton) findViewById(R.id.radio_2A);
                radioOut2a.setVisibility(View.INVISIBLE);
                RadioButton radioOut2b = (RadioButton) findViewById(R.id.radio_2B);
                radioOut2b.setVisibility(View.INVISIBLE);
                break;
            case 3:
                RadioButton radioOut3a = (RadioButton) findViewById(R.id.radio_3C);
                radioOut3a.setVisibility(View.INVISIBLE);
                RadioButton radioOut3b = (RadioButton) findViewById(R.id.radio_3D);
                radioOut3b.setVisibility(View.INVISIBLE);
                break;
            case 4:
                RadioButton radioOut4a = (RadioButton) findViewById(R.id.radio_4B);
                radioOut4a.setVisibility(View.INVISIBLE);
                RadioButton radioOut4b = (RadioButton) findViewById(R.id.radio_4D);
                radioOut4b.setVisibility(View.INVISIBLE);
                break;
            case 6:
                RadioButton radioOut6a = (RadioButton) findViewById(R.id.radio_6A);
                radioOut6a.setVisibility(View.INVISIBLE);
                RadioButton radioOut6b = (RadioButton) findViewById(R.id.radio_6B);
                radioOut6b.setVisibility(View.INVISIBLE);
                break;
        }
    }
}