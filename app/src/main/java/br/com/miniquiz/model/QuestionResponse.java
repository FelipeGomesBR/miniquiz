package br.com.miniquiz.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionResponse {

    @SerializedName("id")
    private String id;
    @SerializedName("statement")
    private String statement;
    @SerializedName("options")
    private List<String> options = null;
    private String answerOption = "";

    /**
     *
     * @param statement
     * @param id
     * @param options
     */
    public QuestionResponse(String id, String statement, List<String> options) {
        this.id = id;
        this.statement = statement;
        this.options = options;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(String answerOption) {
        this.answerOption = answerOption;
    }
}