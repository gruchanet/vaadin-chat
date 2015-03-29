package com.gruchanet.vaadin.chat.helper.formatter.emoticon;

public class EmoticonFormatter {

    public static String encloseWithPipe(String text) {
        return encloseWith(text, EmoticonEnclosureType.PIPE);
    }

    public static String encloseWith(String text, EmoticonEnclosureType enclosureType) {
        return enclosureType.getEnclosure() + text + enclosureType.getEnclosure();
    }
}
