package br.com.miniquiz.common;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import br.com.miniquiz.R;
import br.com.miniquiz.utils.AlertUtil;

public class CommonActivity extends AppCompatActivity implements CommonLoaderInteraction {

    private ProgressDialog progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        progress = new ProgressDialog(this, R.style.AppCompatAlertDialogStyle);
        super.onCreate(savedInstanceState);
    }

    protected void callFragment(Fragment fragment, int resources) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(resources, fragment);
        ft.commit();
    }

    @Override
    public void showLoader() {
        progress.setMessage(getResources().getString(R.string.loading));
        progress.setCancelable(false);
        progress.show();
    }

    @Override
    public void showMessage(String message) {
        AlertUtil.showAlert(this, message);
    }

    @Override
    public void showMessage(int message) {
        AlertUtil.showAlert(this, getResources().getString(message));
    }

    @Override
    public void hideLoader() {
        progress.dismiss();
    }
}

