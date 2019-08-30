package br.com.miniquiz.common;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import br.com.miniquiz.R;
import br.com.miniquiz.utils.AlertUtil;
import io.reactivex.annotations.Nullable;

/**
 * Created by Felipe Gomes on 28/08/19.
 */
public class CommonFragment extends Fragment implements CommonLoaderInteraction{

    private ProgressDialog progress;

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        progress = new ProgressDialog(getActivity(), R.style.AppCompatAlertDialogStyle);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showLoader() {
        progress.setMessage(getResources().getString(R.string.loading));
        progress.setCancelable(false);
        progress.show();
    }

    @Override
    public void showMessage(String message) {
        AlertUtil.showAlert(getActivity(), message);
    }

    @Override
    public void showMessage(int message) {
        AlertUtil.showAlert(getActivity(), getResources().getString(message));
    }

    @Override
    public void hideLoader() {
        progress.dismiss();
    }
}
