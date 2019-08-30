package br.com.miniquiz.common;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.miniquiz.model.AnswerRequest;
import br.com.miniquiz.model.AnswerResponse;
import br.com.miniquiz.model.QuestionResponse;
import io.reactivex.Observable;

@Singleton
public class Service {

    private final Api api;
    @Inject
    public Service(Api api) {
        this.api = api;
    }

    public Observable<QuestionResponse> getQuestion() {
        return api.getQuestion();
    }

    public Observable<AnswerResponse> sendAnswer(String idQuestion, String answer) {
        AnswerRequest answerRequest = new AnswerRequest(answer);
        return api.sendAnswer(idQuestion, answerRequest);
    }
}
