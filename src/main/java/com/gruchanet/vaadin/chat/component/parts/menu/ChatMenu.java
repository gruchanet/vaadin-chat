package com.gruchanet.vaadin.chat.component.parts.menu;

import com.gruchanet.vaadin.chat.domain.User;
import com.gruchanet.vaadin.chat.helper.Session;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.*;

public class ChatMenu extends CustomComponent {

    public ChatMenu() {
        setStyleName("valo-menu");
        setSizeUndefined();

        setCompositionRoot(buildContent());
    }

    private Component buildContent() {
        final CssLayout menuContent = new CssLayout();
        menuContent.addStyleName("sidebar");
        menuContent.addStyleName(ValoTheme.MENU_PART);
        menuContent.addStyleName("no-vertical-drag-hints");
        menuContent.addStyleName("no-horizontal-drag-hints");
        menuContent.setWidth(null);
        menuContent.setHeight("100%");

        menuContent.addComponent(buildTitle());
        menuContent.addComponent(buildToggleButton());
        menuContent.addComponent(buildUserMenu());
        menuContent.addComponent(buildMenuItems());

        return menuContent;
    }

    private Component buildTitle() {
        Label logo = new Label("Be<strong>Chat</strong>", ContentMode.HTML);
        logo.setSizeUndefined();

        HorizontalLayout logoWrapper = new HorizontalLayout(logo);
        logoWrapper.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
        logoWrapper.addStyleName("valo-menu-title");

        return logoWrapper;
    }

    private Component buildToggleButton() {
        final Button menuToggleButton = new Button("Menu", new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                if (getCompositionRoot().getStyleName().contains("valo-menu-visible")) {
                    getCompositionRoot().removeStyleName("valo-menu-visible");
                } else {
                    getCompositionRoot().addStyleName("valo-menu-visible");
                }
            }
        });
        menuToggleButton.setIcon(FontAwesome.LIST);
        menuToggleButton.addStyleName("valo-menu-toggle");
        menuToggleButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
        menuToggleButton.addStyleName(ValoTheme.BUTTON_SMALL);

        return menuToggleButton;
    }

    private Component buildUserMenu() {
        final MenuBar settings = new MenuBar();
        final MenuItem settingsItem;
        final User user = Session.getCurrentUser();

        settings.addStyleName("user-menu");
        settingsItem = settings.addItem("", new ExternalResource(user.getGravatarURL()), null);
        settingsItem.setText(user.getName());
        settingsItem.addItem("Edit name/e-mail", new MenuBar.Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                // TODO: window
            }
        });

        return settings;
    }

    private Component buildMenuItems() {
        final CssLayout menuItemsLayout = new CssLayout();
        menuItemsLayout.addStyleName("valo-menuitems");
        menuItemsLayout.setHeight(100.0f, Unit.PERCENTAGE);

        for (MenuItemType menuItem : MenuItemType.values()) {
            Button menuItemBtn = new MenuItemButton(menuItem);

            menuItemsLayout.addComponent(menuItemBtn);
        }

        return menuItemsLayout;
    }

    public final class MenuItemButton extends Button {

        private static final String STYLE_SELECTED = "selected";
        private final MenuItemType menuItem;

        public MenuItemButton(final MenuItemType menuItem) {
            this.menuItem = menuItem;

            setSizeFull();
            setPrimaryStyleName("valo-menu-item");

            setIcon(menuItem.getIcon());
            setCaption(menuItem.getDescription());
            setCaptionAsHtml(true);

            addClickListener(new ClickListener() {
                @Override
                public void buttonClick(final ClickEvent event) {
                    UI.getCurrent().getNavigator().navigateTo(menuItem.getNavigationLink());
                }
            });
        }
    }
}
