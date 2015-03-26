package com.gruchanet.vaadin.chat.components.parts;

import com.gruchanet.vaadin.chat.domain.User;
import com.gruchanet.vaadin.chat.helper.RandomStringGenerator;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class TopBar extends HorizontalLayout {

    private Button homeBtn = new Button(null, FontAwesome.HOME);
    private FormLayout userForm = new FormLayout();

    private User user = new User();
    private ObjectProperty userName = new ObjectProperty<>(user.getName());
    private TextField userNameInput = new TextField("Your name: ", userName);

    public TopBar() {
        setMargin(true);
        setSpacing(true);
        setStyleName("top-bar");

        initLayout();
        initUserName();
    }

    private void initLayout() {
        homeBtn.setStyleName("dark-button");

        userNameInput.setIcon(FontAwesome.USER);
        userNameInput.setImmediate(true);
        userForm.addComponents(
                userNameInput
        );

        addComponents(
//                homeBtn,
                userForm
        );
    }

    private void initUserName() {
        try {
            user.setName(
                    "~anon" + RandomStringGenerator.generateRandomString(
                            6,
                            RandomStringGenerator.Mode.NUMERIC
                    )
            );
        } catch (Exception ex){
            user.setName("~anonymous");
        }

        userName.setValue(user.getName());
    }
}
