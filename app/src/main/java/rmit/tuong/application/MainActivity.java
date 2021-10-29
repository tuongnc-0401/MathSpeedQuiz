package rmit.tuong.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.graphics.LinearGradient;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_name;
    ImageView btn_add, btn_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize all components
        initial();

        // onClick function for buttons
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AdditionGame.class);
                startActivity(i);
                finish();
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TrueFalseGame.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void initial() {
        btn_add = findViewById(R.id.btn_add);
        btn_2 = findViewById(R.id.btn2);
        txt_name = findViewById(R.id.txt_name);
    }
}