package tech.tresearchgroup.babygalago.view.pages;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.controller.controllers.NotificationController;
import tech.tresearchgroup.babygalago.controller.controllers.QueueController;
import tech.tresearchgroup.babygalago.view.components.HeadComponent;
import tech.tresearchgroup.babygalago.view.components.SideBarComponent;
import tech.tresearchgroup.babygalago.view.components.TopBarComponent;
import tech.tresearchgroup.palila.controller.components.InputBoxComponent;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.babygalago.model.ExtendedUserEntity;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import static j2html.TagCreator.*;

@AllArgsConstructor
public class ProfilePage {
    private final SettingsController settingsController;
    private final NotificationController notificationController;

    public byte @NotNull [] render(boolean loggedIn, ExtendedUserEntity userEntity) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        PermissionGroupEnum permissionGroupEnum = PermissionGroupEnum.ALL;
        String username = null;
        String email = null;
        if (userEntity != null) {
            permissionGroupEnum = userEntity.getPermissionGroup();
            username = userEntity.getUsername();
            email = userEntity.getEmail();
        }
        return document(
            html(
                HeadComponent.render(settingsController.getServerName()),
                TopBarComponent.render(notificationController.getNumberOfUnread(userEntity), QueueController.getQueueSize(), loggedIn, permissionGroupEnum),
                SideBarComponent.render(loggedIn,
                    settingsController.isMovieLibraryEnable(),
                    settingsController.isTvShowLibraryEnable(),
                    settingsController.isGameLibraryEnable(),
                    settingsController.isMusicLibraryEnable(),
                    settingsController.isBookLibraryEnable()),
                body(
                    div(
                        form(
                            label("Profile summary").withClass("overviewLabel"),
                            br(),
                            br(),

                            InputBoxComponent.render("username", "Username: ", username),
                            br(),

                            InputBoxComponent.render("email", "Email: ", email),
                            br(),

                            label("Password: "),
                            input().withType("password").withName("password"),
                            br(),

                            label("Password again: "),
                            input().withType("password").withName("passwordConfirm"),
                            br(),
                            button("Save").withType("submit")
                        ).withAction("/profile").withMethod("POST")
                    ).withClass("body")
                )
            )
        ).getBytes();
    }
}
