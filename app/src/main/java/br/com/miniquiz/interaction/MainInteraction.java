package br.com.miniquiz.interaction;

import androidx.fragment.app.Fragment;
import br.com.miniquiz.common.CommonLoaderInteraction;

public interface MainInteraction extends CommonLoaderInteraction {
    void setFrame(Fragment fragment);
    void setNameButton(int stringButton);
}
