package com.example.android.videogamesquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method checks the answer to question 1.
     */
    private void checkSonicQuestion() {
        EditText sonicName = findViewById(R.id.sonic_field);
        String sonic = sonicName.getText().toString();
        if (sonic.equalsIgnoreCase("Sonic")) {
            totalScore += 1;
        }
    }

    /**
     * This method checks the answer to question 2.
     */
    private void checkKojimaQuestion() {
        RadioButton kojimaButton = findViewById(R.id.kojima_radio_button);
        boolean isKojimaChecked = kojimaButton.isChecked();
        if (isKojimaChecked) {
            totalScore += 1;
        }
    }

    /**
     * This method checks the answer to question 3.
     */
    private void checkMdSaturnQuestion() {
        CheckBox megaDriveCheckbox = findViewById(R.id.mega_drive_checkbox);
        CheckBox saturnCheckbox = findViewById(R.id.saturn_checkbox);
        CheckBox jaguarCheckbox = findViewById(R.id.jaguar_checkbox);
        boolean megaDriveIsChecked = megaDriveCheckbox.isChecked();
        boolean saturnIsChecked = saturnCheckbox.isChecked();
        boolean jaguarIsChecked = jaguarCheckbox.isChecked();

        if (megaDriveIsChecked && saturnIsChecked && !jaguarIsChecked) {
            totalScore += 1;
        }
    }

    /**
     * This method checks the answer to question 4.
     */
    private void checkXboxQuestion() {
        RadioButton xboxButton = findViewById(R.id.xbox_radio_button);
        boolean isXboxChecked = xboxButton.isChecked();
        if (isXboxChecked) {
            totalScore += 1;
        }
    }

    /**
     * This method checks the answer to question 5.
     */
    private void checkDreamcastQuestion() {
        EditText dreamcastName = findViewById(R.id.dreamcast_field);
        String dreamcast = dreamcastName.getText().toString();
        if (dreamcast.equalsIgnoreCase("Dreamcast")) {
            totalScore += 1;
        }
    }

    /**
     * This method calculates the score when the 'Score Me!' button is pressed.
     */
    public void checkScore(View view) {

        totalScore = 0;

        checkSonicQuestion();
        checkKojimaQuestion();
        checkMdSaturnQuestion();
        checkXboxQuestion();
        checkDreamcastQuestion();

        //These are the toasts that display different messages depending on the score achieved.

        String msg = "";

        if (totalScore == 0) {
            msg = "Snake? Snaaaaaaaaaake??!!";
        } else if (totalScore == 1) {
            msg = "Game over man, GAME OVER!";
        } else if (totalScore == 2) {
            msg = "You must defeat Sheng Long to stand a chance!";
        } else if (totalScore == 3) {
            msg = "Hey Stranger, where'd you learn to fight like that?";
        } else if (totalScore == 4) {
            msg = "Prey slaughtered!";
        } else {
            msg = "You have reached Valhalla!";
        }
        String scoreMessage = "You scored " + totalScore + " out of 5! " + msg;
        Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();


    }
}