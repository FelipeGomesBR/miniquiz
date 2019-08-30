package br.com.miniquiz.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

import androidx.annotation.StringDef;

public class FontManager {

    @StringDef({THIN, EXTRALIGHT, LIGHT, REGULAR, MEDIUM, SEMI_BOLD, BOLD, EXTRA_BOLD, BLACK})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontType{}

    private static final String THIN = "Thin";
    private static final String EXTRALIGHT = "ExtraLight";
    private static final String LIGHT = "Light";
    private static final String REGULAR = "Regular";
    private static final String MEDIUM = "Medium";
    private static final String SEMI_BOLD = "SemiBold";
    private static final String BOLD = "Bold";
    private static final String EXTRA_BOLD = "ExtraBold";
    private static final String BLACK = "Black";


    private Context context;
    private HashMap<String, Typeface> typefaces;

    public FontManager(Context context) {
        this.context = context;
        typefaces = new HashMap<>();
    }

    public Typeface get(@FontType String type) {

        Typeface typeface = typefaces.get(type);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), type + ".ttf");
            typefaces.put(type, typeface);
        }

        return typeface;
    }
}
