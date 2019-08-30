package br.com.miniquiz.di;

import javax.inject.Singleton;

import br.com.miniquiz.ui.InitialFrame;
import br.com.miniquiz.ui.MainActivity;
import br.com.miniquiz.ui.QuestionFrame;
import br.com.miniquiz.ui.ResultFrame;
import br.com.miniquiz.utils.FontManager;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    FontManager getFontManager();

    void inject(MainActivity mainActivity);
    void inject(InitialFrame initialFrame);
    void inject(QuestionFrame questionFrame);
    void inject(ResultFrame resultFrame);
}