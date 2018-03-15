package com.geoquiz.geoquiz;

public class Question {

    private int mTextResId;
    private int mTextAnswId;
    private boolean mAnswerTrue;
    protected int mHint;


    public Question(int textResId, int textAnswId, boolean answerTrue) {
        mHint = R.string.hints;
        mTextResId = textResId;
        mTextAnswId = textAnswId;
        mAnswerTrue = answerTrue;
    }

    public int getTextAnswId() {
        return mTextAnswId;
    }

    public void setTextAnswId(int textAnswId) {
        mTextAnswId = textAnswId;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
