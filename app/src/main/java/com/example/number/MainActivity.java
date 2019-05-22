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
    int try_cnt = 0;

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

                if(try_cnt < 9){
                    guess = Integer.parseInt(etInput.getText().toString());
                    if (guess > numberToGuess)
                        tvInfo.setText(getResources().getString(R.string.ahead) + " Осталось попыток: " + String.valueOf(9-try_cnt));
                    if (guess < numberToGuess)
                        tvInfo.setText(getResources().getString(R.string.behind) + " Осталось попыток: " + String.valueOf(9-try_cnt));
                    if (guess == numberToGuess)
                    {
                        tvInfo.setText(getResources().getString(R.string.hit));
                        bControl.setText(getResources().getString(R.string.play_more));
                        win = true;
                        try_cnt = 0;
                    }
                    try_cnt += 1;
                }
                else {
                    bControl.setText(getResources().getString(R.string.play_more));
                    tvInfo.setText("Вы проиграли! Правильный ответ: " + String.valueOf(numberToGuess));
                    numberToGuess = rand.nextInt(100);
                    win = true;
                    try_cnt = 0;
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





