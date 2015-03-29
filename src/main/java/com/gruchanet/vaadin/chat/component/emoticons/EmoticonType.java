package com.gruchanet.vaadin.chat.component.emoticons;

import java.util.HashMap;
import java.util.Map;

public enum EmoticonType {
    SMILE(": )", "smile.gif"),
    SMILE_EYE("; )", "smile_eye.gif"),
    SMILE2(": >", "smile2.gif"),
    SMILE3(": ]", "smile3.gif"),
    SMILE3_EYE("; ]", "smile4.gif"),
    SAD(": (", "sad.gif"),
    SAD2(": |", "sad2.gif"),
    SAD2_EYE("; |", "sad3.gif"),
    TONGUE(": P", "tongue.gif"),
    TONGUE_EYE("; P", "tongue_eye.gif"),
    KISS(": *", "kiss.gif", false),
    KISS_EYE("; *", "kiss.gif"),
    SIGHS(": /", "sighs.gif"),
    SIGHS_EYE("; /", "sighs.gif", false);

    private static final Map<String, EmoticonType> lookup = new HashMap<>();
    static {
        for (EmoticonType emoticon : EmoticonType.values())
            lookup.put(emoticon.getText(), emoticon);
    }

    private String text;
    private String file;
    private boolean isShown;

    private EmoticonType(String text, String file) {
        this(text, file, true);
    }

    private EmoticonType(String text, String file, boolean isShown) {
        this.text = text;
        this.file = file;
        this.isShown = isShown;
    }

    public String getText() {
        return text;
    }

    public String getFile() {
        return file;
    }

    public boolean isShown() {
        return isShown;
    }

    public static EmoticonType get(String text) {
        return lookup.get(text);
    }
}
