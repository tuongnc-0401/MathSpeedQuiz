package rmit.tuong.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AdditionGame extends AppCompatActivity {

    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_clear, btn_ok;
    TextView txt_answer, txt_question, txt_countdown, txt_score;
    ProgressBar progress_countdown;
    GamePlay game =new GamePlay();
    // countdown 45 seconds
    int timeRemain = 45;
    CountDownTimer countDownTimer = new CountDownTimer(timeRemain * 1000, 1000) {
        @Override
        public void onTick(long l) { // display sec on the screen
            timeRemain--;
            txt_countdown.setText(timeRemain + " sec");
            progress_countdown.setProgress(timeRemain);
        }

        // when time run out, move to result screen and notify score
        @Override
        public void onFinish() {
            countDownTimer.cancel();
            Toast.makeText(AdditionGame.this, "Time up!", Toast.LENGTH_SHORT).show();
            // delay 2sec and move to result screen.
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(AdditionGame.this, ResultActivity.class);
                    intent.putExtra("score", game.getScore());
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            },2000);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_game);
        setTitle("Math Speed Quiz");
        // initial all components
        initial();

        //start game
        startGame();
        countDownTimer.start();
        // set onClick for all numbers buttons
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btnClicked = (Button) view;
                int answerValue = Integer.parseInt(btnClicked.getText().toString());
                int currentValue = Integer.parseInt(txt_answer.getText().toString());
                int newValue = currentValue * 10 + answerValue;
                txt_answer.setText(String.valueOf(newValue));

            }
        };
        // set onClick for all button numbers
        btn_0.setOnClickListener(numberClickListener);
        btn_1.setOnClickListener(numberClickListener);
        btn_2.setOnClickListener(numberClickListener);

        btn_3.setOnClickListener(numberClickListener);
        btn_4.setOnClickListener(numberClickListener);
        btn_5.setOnClickListener(numberClickListener);

        btn_6.setOnClickListener(numberClickListener);
        btn_7.setOnClickListener(numberClickListener);
        btn_8.setOnClickListener(numberClickListener);
        btn_9.setOnClickListener(numberClickListener);

        // set onClick for clear button
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_answer.setText("0");
            }
        });

        // set onClick for Ok button
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the answer of this question
               int answerResult = Integer.parseInt(txt_answer.getText().toString());
               int answerCheck = game.getCurrent().getAnswer();
                // check the true or false
                boolean flag = game.checkAns(answerResult);
                // if true, increase point
                if(flag){
                    Toast.makeText(AdditionGame.this, "Correct!", Toast.LENGTH_SHORT).show();
                    txt_score.setText(Integer.toString(game.getScore()) + " pts");
                    txt_answer.setText("0");
                    startGame();
                } else { // if wrong, notify for users.
                    txt_answer.setText("0");
                    Toast.makeText(AdditionGame.this, "Wrong Answer! ", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    // start game by creating a new question
    private void startGame() {
        game.createNewExpression();
        int answer =  game.getCurrent().getAnswer();
        txt_question.setText(game.getCurrent().getQuestion());
    }

    private void initial() {
        // initialize all buttons
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);

        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);

        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_clear = findViewById(R.id.btn_clear);
        btn_ok = findViewById(R.id.btn_ok);

        // initialize Text View
        txt_answer = findViewById(R.id.txt_answer);
        txt_question = findViewById(R.id.txt_question);
        txt_countdown = findViewById(R.id.txt_countdown2);
        txt_score = findViewById(R.id.txt_score2);

        // progressBar
        progress_countdown = findViewById(R.id.progress_countdown1);
    }

    // when user press the back press, it clear everything and go to Main Activity
    @Override
    public void onBackPressed() {
        countDownTimer.cancel();
        Intent i2 = new Intent(AdditionGame.this, MainActivity.class);
        i2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i2);

    }
}