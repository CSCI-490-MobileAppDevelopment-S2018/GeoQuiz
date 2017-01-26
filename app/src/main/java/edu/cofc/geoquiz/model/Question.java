package edu.cofc.geoquiz.model;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by kbriggs on 12/31/16.
 */
public class Question {

    private int textResId;
    private boolean answerTrue;

    public Question(int textResId, boolean answerTrue) {
        this.textResId = textResId;
        this.answerTrue = answerTrue;
    }

    /*
        Auto-generated getters and setters
        Code -> Generate -> Getter and Setter
     */

    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
