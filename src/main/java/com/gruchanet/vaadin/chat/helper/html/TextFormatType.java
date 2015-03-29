package com.gruchanet.vaadin.chat.helper.html;

public enum TextFormatType {
    BOLD("b"),
    ITALIC("i"),
    UNDERSCORE("u"),
    STRIKE("s");

    private final String tag;

    private TextFormatType (final String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
