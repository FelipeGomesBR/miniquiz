package br.com.miniquiz.viewmodel;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.databinding.ObservableField;
import br.com.miniquiz.R;
import br.com.miniquiz.common.Service;
import br.com.miniquiz.interaction.MainInteraction;
import br.com.miniquiz.interaction.QuestionInteraction;
import br.com.miniquiz.interaction.ResultInteraction;
import br.com.miniquiz.model.QuestionResponse;
import br.com.miniquiz.model.ScreenEnum;
import br.com.miniquiz.ui.InitialFrame;
import br.com.miniquiz.ui.QuestionFrame;
import br.com.miniquiz.ui.ResultFrame;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


@Singleton
public class MainViewModel {

    private MainInteraction mainInteraction;
    private QuestionInteraction questionInteraction;
    private ResultInteraction resultInteraction;
    private Service service;
    private Integer countQuestionVm = 0;
    private Integer countCorrect = 0;

    private boolean isAnswer = false;
    public ObservableField<String> nameUser;
    public ObservableField<QuestionResponse> question;
    public ObservableField<Integer> countQuestion;
    public ObservableField<String> resultQuestions;
    private ScreenEnum screenEnum;

    @Inject
    public MainViewModel(Service service) {
        this.service = service;
        nameUser = new ObservableField<>("");
        countQuestion = new ObservableField<>(2);
        question = new ObservableField<>();
        resultQuestions = new ObservableField<>("0%");
    }

    public void setMainInteraction(MainInteraction mainInteraction) {
        this.mainInteraction = mainInteraction;
    }

    public void setQuestionInteraction(QuestionInteraction questionInteraction) {
        this.questionInteraction = questionInteraction;
    }

    public void setResultInteraction(ResultInteraction resultInteraction) {
        this.resultInteraction = resultInteraction;
    }

    public void initialMain() {
        screenEnum = ScreenEnum.INITIAL;
        mainInteraction.setFrame(new InitialFrame());
    }

    public void nextFrame() {
        if (screenEnum == ScreenEnum.RESULT) {
            this.clearQuestions();
            this.initialMain();
        } else {
            if (nameUser.get().equals("")) {
                mainInteraction.showMessage(R.string.initial_name_empty);
                return;
            }
            if (isAnswer) {
                this.verifyAnswer();
            } else if (countQuestionVm != countQuestion.get()) {
                screenEnum = ScreenEnum.QUESTION;
                countQuestionVm++;
                mainInteraction.setFrame(new QuestionFrame());
                isAnswer = !isAnswer;
            } else {
                screenEnum = ScreenEnum.RESULT;
                mainInteraction.setFrame(new ResultFrame());
            }
        }

    }

    public void getQuestion() {
        mainInteraction.showLoader();
        service.getQuestion()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(simpleResponse -> {
                    mainInteraction.hideLoader();
                    question.set(simpleResponse);
                    questionInteraction.setQuestion(simpleResponse);
                }, throwable -> {
                    mainInteraction.hideLoader();
                    mainInteraction.showMessage(R.string.error_get_question);
                });
    }

    public void sendAnswer() {
        mainInteraction.showLoader();
        service.sendAnswer(question.get().getId(), question.get().getAnswerOption())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(simpleResponse -> {
                    mainInteraction.hideLoader();
                    if (simpleResponse.getResult()) {
                        mainInteraction.showMessage(R.string.question_correct);
                        countCorrect++;
                        question.get().setAnswerOption(null);
                    } else {
                        mainInteraction.showMessage(R.string.question_wrong);
                    }
                    this.nextFrame();
                }, throwable -> {
                    mainInteraction.hideLoader();
                    mainInteraction.showMessage(R.string.error_get_question);
                });
    }

    public void getResult() {
        resultQuestions.set(String.valueOf((100 / countQuestion.get() * countCorrect)).concat("%"));
    }

    private void verifyAnswer() {
        question.get().setAnswerOption(questionInteraction.getResponse());
        if (question.get().getAnswerOption() != null) {
            this.sendAnswer();
            isAnswer = !isAnswer;
        } else {
            mainInteraction.showMessage(R.string.question_empty);
        }
    }

    private void clearQuestions() {
        countQuestionVm = countCorrect = 0;
        isAnswer = false;
        nameUser = new ObservableField<>("");
        question = new ObservableField<>();
        resultQuestions = new ObservableField<>("0%");
    }

    public void setButtonName(int buttonName) {
        mainInteraction.setNameButton(buttonName);
    }
    public void setName() {
        resultInteraction.setName(nameUser.get());
    }


}