package rmit.tuong.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class TrueFalseGame extends AppCompatActivity {

    ImageView btn_yes, btn_no;
    ProgressBar progress_countdown;
    TextView txt_score, txt_countdown, txt_question, txt_info;
    GamePlayTrueFalse game = new GamePlayTrueFalse();


    // Count down for each question
    int timeRemain = 11; // each question has 10 seconds
    CountDownTimer countDownTimer = new CountDownTimer(timeRemain * 1000, 1000) {
        @Override
        public void onTick(long l) {
            timeRemain--;
            txt_countdown.setText(timeRemain + " sec");
            progress_countdown.setProgress(timeRemain);
        }

        @Override
        public void onFinish() {
            // notify TIME UP
            Toast.makeText(TrueFalseGame.this, "Time up!", Toast.LENGTH_SHORT).show();
            countDownTimer.cancel();
            // Delay 2 seconds and than move to Result screen
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(TrueFalseGame.this, ResultActivity.class);
                    intent.putExtra("score", game.getScore());
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }, 1000);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false_game);
        initial();
        //start game
        startGame();
        // start to count down
        countDownTimer.start();

        // Btn for answer NO
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = game.checkAns(0);
                checkResult(flag);
            }
        });

        // Btn for answer YES
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = game.checkAns(1);
                checkResult(flag);
            }
        });

    }

    /**
     * initialize all component
     */
    private void initial() {
        btn_yes = findViewById(R.id.btn_yes);
        btn_no = findViewById(R.id.btn_no);
        progress_countdown = findViewById(R.id.progress_countdown2);
        txt_score = findViewById(R.id.txt_score2);
        txt_countdown = findViewById(R.id.txt_countdown2);
        txt_question = findViewById(R.id.txt_question2);
        txt_info = findViewById(R.id.txt_info);
    }

    /**
     * start the game, generate question and answer
     */
    private void startGame() {
        game.createNewExpression();
        int answer = game.getCurrent().getAnswer();
        txt_question.setText(game.getCurrent().getQuestion());
    }

    /**
     * check the result of users
     * @param flag the comparison between user's choice and answer
     */
    public void checkResult(boolean flag) {
        // User choose the right answer
        if (flag) {
            txt_info.setText("Correct!");
            txt_score.setText(Integer.toString(game.getScore()) + " pts");
            startGame();
            countDownTimer.cancel();

            timeRemain = 11 - (game.getNumOfCorrect() / 4);
            if (timeRemain < 5) {
                timeRemain = 5;
            }
            countDownTimer.start();

        } else { // user choose the wrong answer
            txt_info.setText("Wrong Answer! ");
            countDownTimer.cancel();
            // Delay 1 second and move to Result screen
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(TrueFalseGame.this, ResultActivity.class);
                    intent.putExtra("score", game.getScore());
                    intent.putExtra("msg", 1);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }, 1000);
        }
    }

    // when user press the back press, it clear everything and go to Main Activity
    @Override
    public void onBackPressed() {
        countDownTimer.cancel();
        Intent i2 = new Intent(TrueFalseGame.this, MainActivity.class);
        i2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i2);
        finish();
    }
}