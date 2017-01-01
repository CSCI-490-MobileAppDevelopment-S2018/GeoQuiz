package edu.cofc.geoquiz.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.cofc.geoquiz.R;
import edu.cofc.geoquiz.model.Question;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;

    private Question[] questionBank = new Question[] {
            new Question(R.string.charleston_question, false),
            new Question(R.string.cofc_question, true),
            new Question(R.string.columbia_question, true),
            new Question(R.string.holy_city_question, false),
            new Question(R.string.marion_question, true),
            new Question(R.string.morris_island_question, false),
    };

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = (TextView) findViewById(R.id.question_text_view);
        int question = questionBank[currentIndex].getTextResId();
        questionTextView.setText(question);

        // Find the resource and set the listener
        trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Make a Toast message when the button is pushed
                Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        });

        // Find the resource and set the listener
        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Make a Toast message when the button is pushed
                Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();

            }
        });

        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % questionBank.length;
                int question = questionBank[currentIndex].getTextResId();
                questionTextView.setText(question);
            }
        });


    }
}
