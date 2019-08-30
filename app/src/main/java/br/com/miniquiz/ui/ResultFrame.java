package br.com.miniquiz.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import br.com.miniquiz.App;
import br.com.miniquiz.R;
import br.com.miniquiz.databinding.FrameResultBinding;
import br.com.miniquiz.interaction.ResultInteraction;
import br.com.miniquiz.viewmodel.MainViewModel;
import io.reactivex.annotations.Nullable;

/**
 * Created by Felipe Gomes on 28/08/19.
 */
public class ResultFrame extends Fragment implements ResultInteraction {
    @Inject
    MainViewModel mainViewModel;
    public FrameResultBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.frame_result,
                container, false);
        injectDependencies();
        binding.setMainVM(mainViewModel);
        mainViewModel.getResult();
        mainViewModel.setButtonName(R.string.result_btn);
        mainViewModel.setResultInteraction(this);
        mainViewModel.setName();
        return binding.getRoot();
    }

    private void injectDependencies() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void setName(String nameUser) {
        binding.txtTitleResult.setText(this.getResources().getString(R.string.result_title, nameUser));
    }
}

