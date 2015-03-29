package com.gruchanet.vaadin.chat.helper.html;

public class HTMLFormatter {

    public static String formatText(String text, TextFormatType formatType) {
        return formatTextToHTML(text, formatType.getTag());
    }

    private static String formatTextToHTML(String text, String tag) {
        return "<" + tag + ">" + text + "</" + tag + ">";
    }
}
