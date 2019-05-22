package com.example.number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView GameInfo;
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Random rand = new Random();

    int numberToGuess;
    int guess;
    boolean win = false;
    int try_cnt = 0;
    int lim = 100;
    int num_try = 5;

    StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameInfo = findViewById(R.id.textView1);
        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);

        sb.append(" Сложно");
        sb.append("\r\n Интервал: 0-100");
        sb.append("\r\n Число попыток: 5");
        GameInfo.setText(sb.toString());
        GameInfo.setText(sb.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        sb.setLength(0);
        switch (item.getItemId()) {
            case R.id.hard1:
                lim = 10;
                num_try = 5;
                numberToGuess = rand.nextInt(lim);

                sb.append(" Легко");
                sb.append("\r\n Интервал: 0-" + String.valueOf(lim));
                sb.append("\r\n Число попыток: " + String.valueOf(num_try));
                GameInfo.setText(sb.toString());
                sb.setLength(0);

                return true;
            case R.id.hard2:
                lim = 50;
                num_try = 10;
                numberToGuess = rand.nextInt(lim);

                sb.append(" Средне");
                sb.append("\r\n Интервал: 0-" + String.valueOf(lim));
                sb.append("\r\n Число попыток: " + String.valueOf(num_try));
                GameInfo.setText(sb.toString());
                sb.setLength(0);

                return true;
            case R.id.hard3:
                lim = 100;
                num_try = 5;
                numberToGuess = rand.nextInt(lim);

                sb.append(" Сложно");
                sb.append("\r\n Интервал: 0-" + String.valueOf(lim));
                sb.append("\r\n Число попыток: " + String.valueOf(num_try));
                GameInfo.setText(sb.toString());
                sb.setLength(0);

                return true;
            case R.id.menu_exit:
                android.os.Process.killProcess(android.os.Process.myPid());
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }

    }

    public void onClick(View view) {
        try_cnt += 1;
        if (!win){
            if (etInput.getText().toString().equals("")){
                tvInfo.setText("Вы не ввели число!");
            }
            else {

                if(try_cnt < num_try){
                    guess = Integer.parseInt(etInput.getText().toString());
                    if (guess > numberToGuess)
                        tvInfo.setText(getResources().getString(R.string.ahead) + " Осталось попыток: " + String.valueOf(num_try-try_cnt) + String.valueOf(numberToGuess));
                    if (guess < numberToGuess)
                        tvInfo.setText(getResources().getString(R.string.behind) + " Осталось попыток: " + String.valueOf(num_try-try_cnt));
                    if (guess == numberToGuess)
                    {
                        tvInfo.setText(getResources().getString(R.string.hit));
                        bControl.setText(getResources().getString(R.string.play_more));
                        win = true;
                        try_cnt = 0;
                    }
                }
                else {
                    bControl.setText(getResources().getString(R.string.play_more));
                    tvInfo.setText("Вы проиграли! Правильный ответ: " + String.valueOf(numberToGuess));
                    numberToGuess = rand.nextInt(lim);
                    win = true;
                    try_cnt = 0;
                }


            }

        }
        else
        {
            numberToGuess = rand.nextInt(lim);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            win = false;
        }
        etInput.setText("");

    }


}





