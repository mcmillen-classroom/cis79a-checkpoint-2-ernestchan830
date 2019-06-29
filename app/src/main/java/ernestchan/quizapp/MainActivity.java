package ernestchan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;

    TextView score_view;
    Button true_button;

    int score = 0;

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mBackButton;
    private Button mHelpButton;


    private Question[] mQuestions;
    private int mIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mBackButton = (ImageButton) findViewById(R.id.back_button);
        mHelpButton = (Button) findViewById(R.id.hintTextResId);

        score_view = (TextView) findViewById(R.id.score_view);
        score_view.setText("Score: " + score);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mBackButton.setOnClickListener(this);
        mHelpButton.setOnClickListener(this);
//when next button is clicked next button runs

        mTextView = (TextView) findViewById(R.id.text_view);

        mQuestions = new Question[5];
        mIndex = 0;

        mQuestions[0] = new Question(R.string.question_text1, R.string.question_text1_hint, true);
        mQuestions[1] = new Question(R.string.question_text2, R.string.question_text2_hint, false);
        mQuestions[2] = new Question(R.string.question_text3, R.string.question_text3_hint, true);
        mQuestions[3] = new Question(R.string.question_text4, R.string.question_text4_hint, true);
        mQuestions[4] = new Question(R.string.question_text5, R.string.question_text5_hint, false);

        mTextView.setText(mQuestions[mIndex].getTextResId());
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.true_button) {
            checkAnswer(true);
            score++;
            score_view.setText("Score: " + score);

        } else if (view.getId() == R.id.false_button) {
            checkAnswer(false);
                score--;
                score_view.setText("Score: " + score);

        } else if (view.getId() == R.id.next_button) {
            if (mIndex < 4){
                mIndex++;
                mTextView.setText(mQuestions[mIndex].getTextResId());
            }
        } else if (view.getId() == R.id.back_button){
            if (mIndex > 0) {
                mIndex--;
                mTextView.setText(mQuestions[mIndex].getTextResId());
            }
        }  if (view.getId() == R.id.hintTextResId) {
            if (mIndex == 0) {
                Toast myToast = Toast.makeText(this, "Ash has a pokemon called Noctowl that was green." , Toast.LENGTH_LONG);
                myToast.show();
            }
        } if  (view.getId() == R.id.hintTextResId) {
            if (mIndex == 1) {
                Toast myToast =  Toast.makeText(this, "(Mandela Effect) Pikachu has black tipped ears.", Toast.LENGTH_LONG);
                myToast.show();
            }
        } if  (view.getId() == R.id.hintTextResId) {
            if (mIndex == 2) {
                Toast myToast =  Toast.makeText(this, "Pikachu loses a battle against a Gym Leaders Raichu.", Toast.LENGTH_LONG);
                myToast.show();
            }
        } if  (view.getId() == R.id.hintTextResId) {
            if (mIndex == 3) {
                Toast myToast = Toast.makeText(this, "In the Alola region Pikachu faces a bug pokemon in an unsuccessful attempted capture.", Toast.LENGTH_LONG);
                myToast.show();
            }
        } if (view.getId() == R.id.hintTextResId) {
            if (mIndex == 4) {
                Toast myToast = Toast.makeText(this, "He has 3 names such as Green, Blue and a four letter one.", Toast.LENGTH_LONG);
                myToast.show();
            }
        }
    }

        public boolean checkAnswer(boolean userInput){
            if (mQuestions[mIndex].getAnswer() == userInput) {
                Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT);
                myToast.show();
                return true;
            } else {
                Toast myToast = Toast.makeText(this, "You are incorrect", Toast.LENGTH_SHORT);
                myToast.show();
                return false;
            }
        }
    }