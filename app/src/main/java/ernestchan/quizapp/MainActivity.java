package ernestchan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;


    private Question[] mQuestions;
    private int mIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton =  (Button)  findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);


        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
//when next button is clicked next button runs

        mTextView = (TextView) findViewById(R.id.text_view);

        mQuestions = new Question[4];
        mIndex = 0;

        mQuestions[0] = new Question(R.string.question_text1, true);
        mQuestions[1] = new Question(R.string.question_text2, true);
        mQuestions[2] = new Question(R.string.question_text3, true);
        mQuestions[3] = new Question(R.string.question_text4, true);

        mTextView.setText(mQuestions[mIndex].getTextResId());
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.true_button) {
            checkAnswer(true);
        } else if (view.getId() == R.id.false_button) {
            checkAnswer(false);
        } else if (view.getId() == R.id.next_button) {
            mIndex++;
            mTextView.setText(mQuestions[mIndex].getTextResId());
        }

        public boolean checkAnswer ( boolean userInput){
            if (mQuestions[mIndex].getAnswer() == userInput) {
                Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT);
                myToast.show();
                return true;
            } else {
                Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT);
                myToast.show();
                return false;
            }
        }
    }