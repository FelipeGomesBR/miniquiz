package br.com.miniquiz;

import android.app.Application;

import br.com.miniquiz.di.AppComponent;
import br.com.miniquiz.di.AppModule;
import br.com.miniquiz.di.DaggerAppComponent;
import br.com.miniquiz.di.NetworkModule;

public class App extends Application {

    private static AppComponent component;

    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        if (component == null) {
            component =
                    DaggerAppComponent.builder()
                            .appModule(new AppModule(this))
                            .networkModule(new NetworkModule(getResources().getString(R.string.API_BASE_URL)))
                            .build();
        }
    }

    public static AppComponent getAppComponent() {
        return component;
    }

}
