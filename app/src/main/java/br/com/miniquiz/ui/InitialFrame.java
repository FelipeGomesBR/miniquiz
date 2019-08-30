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
import br.com.miniquiz.databinding.FrameInitialBinding;
import br.com.miniquiz.viewmodel.MainViewModel;
import io.reactivex.annotations.Nullable;

/**
 * Created by Felipe Gomes on 28/08/19.
 */
public class InitialFrame extends Fragment{
    @Inject
    MainViewModel mainViewModel;
    public FrameInitialBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.frame_initial,
                container, false);
        injectDependencies();
        binding.setMainVM(mainViewModel);
        mainViewModel.setButtonName(R.string.initial_btn);
        return binding.getRoot();
    }

    private void injectDependencies() {
        App.getAppComponent().inject(this);
    }
}

