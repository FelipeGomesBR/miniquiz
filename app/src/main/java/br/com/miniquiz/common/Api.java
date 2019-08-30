package br.com.miniquiz.common;

import br.com.miniquiz.model.AnswerRequest;
import br.com.miniquiz.model.AnswerResponse;
import br.com.miniquiz.model.QuestionResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @GET("/question")
    Observable<QuestionResponse> getQuestion();

    @POST("/answer")
    Observable<AnswerResponse> sendAnswer(@Query("questionId") String questionId, @Body AnswerRequest answerRequest);

}