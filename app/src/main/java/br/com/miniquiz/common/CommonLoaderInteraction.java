package br.com.miniquiz.common;

public interface CommonLoaderInteraction {
    void showLoader();
    void showMessage(String message);
    void showMessage(int message);
    void hideLoader();
}