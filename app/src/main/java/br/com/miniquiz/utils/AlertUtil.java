package br.com.miniquiz.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;

import br.com.miniquiz.R;

public class AlertUtil {

    public static void showAlert(Activity activity, String message) {
        try {
            AlertDialog.Builder alertDialogBuilder  = setAlert(activity, message);
            alertDialogBuilder.setNegativeButton(activity.getResources().getString(R.string.ok), null);

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        } catch (Exception e) {
            Log.e(AlertUtil.class.toString(), e.getMessage());
        }
    }

    private static AlertDialog.Builder setAlert(Activity activity, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle(activity.getResources().getString(R.string.atention));
        alertDialogBuilder.setMessage(message);
        return alertDialogBuilder;
    }

}
