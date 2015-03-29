package com.gruchanet.vaadin.chat.config;


import com.vaadin.server.VaadinService;

public class Config {

    public final static String EMOTICONS_PATH =
            VaadinService.getCurrent().getBaseDirectory().getAbsolutePath() +
                    "/VAADIN/emoticons/";
}
