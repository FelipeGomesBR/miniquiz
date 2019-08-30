package br.com.miniquiz.model;
import com.google.gson.annotations.SerializedName;

public class AnswerResponse {

    @SerializedName("result")
    private Boolean result;

    /**
     *
     * @param result
     */
    public AnswerResponse(Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
