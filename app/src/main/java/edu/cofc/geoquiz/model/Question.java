package edu.cofc.geoquiz.model;

/**
 * Created by kbriggs on 12/31/16.
 */
public class Question {

    private int testResId;
    private boolean answerTrue;

    public Question(int testResId, boolean answerTrue) {
        this.testResId = testResId;
        this.answerTrue = answerTrue;
    }

    /*
        Auto-generated getters and setters
        Code -> Generate -> Getter and Setter
     */
    public int getTestResId() {
        return testResId;
    }

    public void setTestResId(int testResId) {
        this.testResId = testResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
