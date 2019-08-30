package br.com.miniquiz.model;

import com.google.gson.annotations.SerializedName;

public class AnswerRequest {

    @SerializedName("answer")
    private String answer;

    /**
     *
     * @param answer
     */
    public AnswerRequest(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}