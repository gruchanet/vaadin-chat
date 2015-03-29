package com.gruchanet.vaadin.chat.helper.formatter.html;

public class HTMLFormatter {

    public static String formatText(String text, TextFormatType formatType) {
        return formatTextToHTML(text, formatType.getTag());
    }

    private static String formatTextToHTML(String text, String tag) {
        return "<" + tag + ">" + text + "</" + tag + ">";
    }

    public static String sanitize(String text) {
        return text
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace(" ", "&nbsp;");
    }
}
