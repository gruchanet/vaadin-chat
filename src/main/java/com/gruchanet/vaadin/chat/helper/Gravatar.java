package com.gruchanet.vaadin.chat.helper;

public class Gravatar {

    public static String buildGravatarURL(String email) {
        return buildGravatarURL(email, 64);
    }

    public static String buildGravatarURL(String email, int size) {
        String rating = "G";

        return "http://www.gravatar.com/avatar/" + email + "?d=" + getDefaultURL(size) + "&s=" + size + "&r=" + rating;
    }

    public static String getDefaultURL(int size) {
        return "http://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/twDq00QDud4/s" + size + "-c/photo.jpg";
    }
}
