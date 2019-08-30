package br.com.miniquiz.interaction;

import br.com.miniquiz.common.CommonLoaderInteraction;
import br.com.miniquiz.model.QuestionResponse;

public interface QuestionInteraction extends CommonLoaderInteraction {
    void setQuestion(QuestionResponse question);
    String getResponse();
}
