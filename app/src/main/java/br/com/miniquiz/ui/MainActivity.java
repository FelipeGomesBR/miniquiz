package br.com.miniquiz.ui;

import android.os.Bundle;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import br.com.miniquiz.App;
import br.com.miniquiz.R;
import br.com.miniquiz.common.CommonActivity;
import br.com.miniquiz.databinding.ActivityMainBinding;
import br.com.miniquiz.interaction.MainInteraction;
import br.com.miniquiz.viewmodel.MainViewModel;

@Singleton
public class MainActivity extends CommonActivity implements MainInteraction {
    @Inject
    MainViewModel mainViewModel;
    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        injectDependencies();
        mainViewModel.setMainInteraction(this);

        binding.setMainVM(mainViewModel);
        this.initialMain();
    }

    private void injectDependencies() {
        App.getAppComponent().inject(this);
    }

    private void initialMain() {
        mainViewModel.initialMain();
    }

    @Override
    public void setFrame(Fragment fragment) {
        this.callFragment(fragment, binding.content.getId());
    }

    @Override
    public void setNameButton(int stringButton) {
        binding.btnNext.setText(stringButton);
    }


}

