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

    private Question firstQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton =  (Button)  findViewById(R.id.false_button);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.text_view);

        firstQuestion = new Question(R.string.question_text1, true);
        mTextView.setText(firstQuestion.getTextResId());
    }

    @Override
    public void onClick(View view) {
        TextView myTextView = (TextView) view;
        if(view.getId() == R.id.true_button && firstQuestion.getAnswer() == true)
        {
            Toast myToast = Toast.makeText(this, "You are correct",  Toast.LENGTH_SHORT);
            myToast.show();
        }
        else if(view.getId() == R.id.false_button && firstQuestion.getAnswer() == false)
        {
            Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT);
            myToast.show();
        }
        else
            {
            Toast myToast = Toast.makeText(this, "You are incorrect", Toast.LENGTH_SHORT);
            myToast.show();
        }
    }
}
