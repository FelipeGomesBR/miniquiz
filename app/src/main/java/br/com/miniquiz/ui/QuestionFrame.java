package br.com.miniquiz.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;
import br.com.miniquiz.App;
import br.com.miniquiz.R;
import br.com.miniquiz.common.CommonFragment;
import br.com.miniquiz.databinding.FrameQuestionBinding;
import br.com.miniquiz.interaction.QuestionInteraction;
import br.com.miniquiz.model.QuestionResponse;
import br.com.miniquiz.viewmodel.MainViewModel;
import io.reactivex.annotations.Nullable;

/**
 * Created by Felipe Gomes on 28/08/19.
 */
public class QuestionFrame extends CommonFragment implements QuestionInteraction {
    @Inject
    MainViewModel mainViewModel;
    public FrameQuestionBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.frame_question,
                container, false);
        injectDependencies();
        mainViewModel.setQuestionInteraction(this);
        mainViewModel.setButtonName(R.string.question_btn);
        mainViewModel.getQuestion();
        return binding.getRoot();
    }

    private void injectDependencies() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void setQuestion(QuestionResponse question) {
        binding.txtQuestion.setText(question.getStatement());

        for (int i = 0; i < question.getOptions().size(); i++) {
            RadioButton rdbtn = new RadioButton(getContext());
            rdbtn.setId(View.generateViewId());
            rdbtn.setText(question.getOptions().get(i));
            binding.listAnswer.addView(rdbtn);
        }
    }

    @Override
    public String getResponse() {
        try {
            int selectedId = binding.listAnswer.getCheckedRadioButtonId();
            RadioButton rdbtn = getActivity().findViewById(selectedId);
            return rdbtn.getText().toString();
        } catch (Exception e) {
            return null;
        }

    }

}

