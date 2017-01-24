package edu.cofc.geoquiz.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
        updateQuestion();

        // Find the resource and set the listener
        trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the answer and make the appropriate Toast message
                checkAnswer(true);
            }
        });

        // Find the resource and set the listener
        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the answer and make the appropriate Toast message
                checkAnswer(false);

            }
        });

        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % questionBank.length;
                updateQuestion();
            }
        });

        ImageButton imagebutton = new ImageButton(MainActivity.this);
        imagebutton.setMaxWidth(13);

        LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
        layout.addView(imagebutton);

    }

    private void updateQuestion() {
        int question = questionBank[currentIndex].getTextResId();
        questionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = questionBank[currentIndex].isAnswerTrue();

        int messageResId = 0;

        if(userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}
