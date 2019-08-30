package br.com.miniquiz.model;

/**
 * Created by Felipe Gomes on 30/08/19.
 */
public enum ScreenEnum {
    INITIAL(0),
    QUESTION(1),
    RESULT(2);
    public int id;

    ScreenEnum(int id) {
        this.id = id;
    }
}
