package com.example.number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Random rand = new Random();

    int numberToGuess = rand.nextInt(100);
    int guess;
    boolean win = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);

    }

    public void onClick(View view) {
        if (!win){

            if (etInput.getText().toString().equals("")){
                tvInfo.setText("Вы не ввели число!");
            }
            else {
                guess = Integer.parseInt(etInput.getText().toString());

                if (guess > numberToGuess)
                    tvInfo.setText(getResources().getString(R.string.ahead));
                if (guess < numberToGuess)
                    tvInfo.setText(getResources().getString(R.string.behind));
                if (guess == numberToGuess)
                {
                    tvInfo.setText(getResources().getString(R.string.hit));
                    bControl.setText(getResources().getString(R.string.play_more));
                    win = true;
                }
            }

        }
        else
        {
            numberToGuess = rand.nextInt(100);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            win = false;
        }
        etInput.setText("");

    }


    }


