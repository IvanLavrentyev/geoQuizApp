package com.geoquiz.geoquiz;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueBotton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mQuestionTextView;
    private TextView mAnswerTextView;
    private final static String TAG = "QuizActivily";
    private final static String KEY_INDEX = "index";
    private boolean flag = false;

    private Question[] mQuestionsBank = new Question[]{
            new Question(R.string.question_africa, R.string.answers_africa, true),
            new Question(R.string.question_eurasia, R.string.answers_eurasia, true),
            new Question(R.string.question_north_america, R.string.answers_north_america, true),
            new Question(R.string.qustion_central_america, R.string.answers_central_america, false),
            new Question(R.string.question_south_america, R.string.answers_south_america, true),
            new Question(R.string.question_oceans, R.string.answers_oceans, false),
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState called");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// =========================== connection of view element to resource identificatior ======================
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateQuestion();

        mTrueBotton = (Button) findViewById(R.id.true_button);
        mTrueBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });


        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentIndex == mQuestionsBank.length-1){
                    mCurrentIndex = 0;
                    updateQuestion();
                }else {
                    mCurrentIndex++;
                    updateQuestion();
                }
            }
        });

        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentIndex == 0){
                    mCurrentIndex = mQuestionsBank.length-1;
                    updateQuestion();
                }else {
                    mCurrentIndex--;
                    updateQuestion();
                }
            }
        });

    }

    private void checkAnswer(boolean isAnswerTrue) {
        boolean currentAnswer = mQuestionsBank[mCurrentIndex].isAnswerTrue();
        if (isAnswerTrue == currentAnswer) {
            int answer = mQuestionsBank[mCurrentIndex].getTextAnswId();
            mAnswerTextView.setText(answer);
        } else {
            mAnswerTextView.setText(mQuestionsBank[mCurrentIndex].mHint);
        }
    }

    private void updateQuestion() {
        int question = mQuestionsBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
        mAnswerTextView.setText("");
    }

//    private void returnQuestion() {
//            int question = mQuestionsBank[mCurrentIndex].getTextResId();
//            mQuestionTextView.setText(question);
//            mAnswerTextView.setText("");
//        }
}
