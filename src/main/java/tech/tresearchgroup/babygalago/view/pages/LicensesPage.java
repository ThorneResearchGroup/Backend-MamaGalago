package tech.tresearchgroup.babygalago.view.pages;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.controller.controllers.NotificationController;
import tech.tresearchgroup.babygalago.controller.controllers.QueueController;
import tech.tresearchgroup.babygalago.view.components.HeadComponent;
import tech.tresearchgroup.babygalago.view.components.SideBarComponent;
import tech.tresearchgroup.babygalago.view.components.TopBarComponent;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.babygalago.model.ExtendedUserEntity;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import static j2html.TagCreator.*;

@AllArgsConstructor
public class LicensesPage {
    private final SettingsController settingsController;
    private final NotificationController notificationController;

    public byte @NotNull [] render(boolean loggedIn, ExtendedUserEntity userEntity) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        PermissionGroupEnum permissionGroupEnum = PermissionGroupEnum.ALL;
        if (userEntity != null) {
            permissionGroupEnum = userEntity.getPermissionGroup();
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
                        label("Technologies used:").withClass("overviewLabel"),
                        br(),
                        br(),

                        a("SpectreCSS").withHref("https://picturepan2.github.io/spectre/"),
                        text(" - "),
                        a("License").withHref("https://github.com/picturepan2/spectre/blob/master/LICENSE"),
                        br(),

                        a("J2HTML").withHref("https://j2html.com/"),
                        text(" - "),
                        a("License").withHref("https://github.com/tipsy/j2html/blob/master/LICENSE"),
                        br(),

                        a("MariaDB").withHref("https://mariadb.org/"),
                        text(" - "),
                        a("License").withHref("https://mariadb.com/kb/en/licensing-faq/"),
                        br(),

                        a("SQLite").withHref("https://www.sqlite.org/index.html"),
                        text(" - "),
                        a("License").withHref("https://www.sqlite.org/copyright.html"),
                        br(),

                        a("Hibernate ORM").withHref("https://hibernate.org/"),
                        text(" - "),
                        a("License").withHref("https://hibernate.org/community/license/"),
                        br(),

                        a("Lombok").withHref("https://projectlombok.org/"),
                        text(" - "),
                        a("License").withHref("https://github.com/projectlombok/lombok/blob/master/LICENSE"),
                        br(),

                        a("GSON").withHref("https://github.com/google/gson"),
                        text(" - "),
                        a("License").withHref("https://github.com/google/gson/blob/master/LICENSE"),
                        br(),

                        a("Retrofit").withHref("https://square.github.io/retrofit/"),
                        text(" - "),
                        a("License").withHref("https://github.com/square/retrofit/blob/master/LICENSE.txt"),
                        br(),

                        a("ActiveJ").withHref("https://activej.io/"),
                        text(" - "),
                        a("License").withHref("https://github.com/activej/activej/blob/master/LICENSE"),
                        br()
                    ).withClass("body")
                )
            )
        ).getBytes();
    }
}
