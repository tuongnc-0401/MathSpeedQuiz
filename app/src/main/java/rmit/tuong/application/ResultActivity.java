package rmit.tuong.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    ImageView btn_home;
    TextView txt_result, txt_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // initialize components
        txt_result = findViewById(R.id.txt_result);
        txt_msg =findViewById(R.id.txt_msg);

        // Get score from game
        Intent intent = getIntent();
        if(intent!= null){
            int score = intent.getIntExtra("score", -1);
            if(score != -1){
                txt_result.setText(Integer.toString(score));
            }
            int msg = intent.getIntExtra("msg", 0);
            if (msg == 1){
                txt_msg.setText("Game over!");
            }
        }

        // btn home to return to Main Activity
        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

            }
        });
    }


    // when user press the back press, it clear everything and go to Main Activity
    @Override
    public void onBackPressed() {
        Intent i2 = new Intent(ResultActivity.this, MainActivity.class);
        i2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i2);
    }
}