package com.gruchanet.vaadin.chat.helper.formatter.emoticon;

public enum EmoticonEnclosureType {
    PIPE("|"),
    DOUBLE_MULTIPLY("**"),
    TIDLE("~");

    private String enclosure;

    private EmoticonEnclosureType(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getEnclosure() {
        return enclosure;
    }
}
