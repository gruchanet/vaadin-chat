package com.gruchanet.vaadin.chat.view;

import com.gruchanet.vaadin.chat.MainUI;
import com.gruchanet.vaadin.chat.domain.User;
import com.gruchanet.vaadin.chat.helper.Session;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class LoginView extends VerticalLayout implements View {

    public LoginView() {
        setSizeFull();

        Component loginForm = buildLoginForm();
        addComponent(loginForm);
        setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
    }

    private Component buildLoginForm() {
        FormLayout loginForm = new FormLayout();
        loginForm.setSizeUndefined();
        loginForm.setSpacing(true);

        buildFields(loginForm);

        return loginForm;
    }

    private FormLayout buildFields(FormLayout loginForm) {
        final BeanFieldGroup<User> binder = new BeanFieldGroup<>(User.class);

        final TextField userName = new TextField("User name: ", Session.getCurrentUser().getName());
        userName.setIcon(FontAwesome.USER);
        userName.setImmediate(true);

        final TextField email = new TextField("E-mail: ");
        email.setIcon(FontAwesome.ENVELOPE);
        email.setImmediate(true);

        final Button submitBtn = new Button("Open chat");
        submitBtn.addStyleName(ValoTheme.BUTTON_PRIMARY);
        submitBtn.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        submitBtn.focus();
        submitBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    reattachChatViewPage();
                    UI.getCurrent().getNavigator().navigateTo(MainUI.CHAT_PAGE);
                } catch (Exception ex) {
                    Notification notification = new Notification(
                            "Check form fields and try again!",
                            Notification.Type.WARNING_MESSAGE
                    );
                    notification.setPosition(Position.TOP_CENTER);
                    notification.show(Page.getCurrent());
                }
            }
        });

        loginForm.addComponents(
                userName,
                email,
                submitBtn
        );

        binder.setItemDataSource(Session.getCurrentUser());
        binder.bind(userName, "name");
        binder.bind(email, "email");

        return loginForm;
    }

    private void reattachChatViewPage() {
        UI.getCurrent().getNavigator().addView(MainUI.CHAT_PAGE, new ChatView());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {}
}
