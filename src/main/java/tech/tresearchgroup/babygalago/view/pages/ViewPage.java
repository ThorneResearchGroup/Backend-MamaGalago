package tech.tresearchgroup.babygalago.view.pages;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.controller.controllers.NotificationController;
import tech.tresearchgroup.babygalago.controller.controllers.QueueController;
import tech.tresearchgroup.babygalago.view.components.*;
import tech.tresearchgroup.palila.controller.components.PaginationComponent;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.babygalago.model.ExtendedUserEntity;
import tech.tresearchgroup.schemas.galago.entities.UserSettingsEntity;
import tech.tresearchgroup.schemas.galago.enums.DisplayModeEnum;
import tech.tresearchgroup.schemas.galago.ui.Card;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import static j2html.TagCreator.*;

@AllArgsConstructor
public class ViewPage {
    private final SettingsController settingsController;
    private final NotificationController notificationController;

    public byte @NotNull [] render(boolean loggedIn,
                                   String title,
                                   String type,
                                   String function,
                                   List<Card> cards,
                                   int size,
                                   int currentPage,
                                   long maxPage,
                                   ExtendedUserEntity userEntity) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        PermissionGroupEnum permissionGroupEnum = PermissionGroupEnum.ALL;
        UserSettingsEntity userSettingsEntity = null;
        if (userEntity != null) {
            permissionGroupEnum = userEntity.getPermissionGroup();
            userSettingsEntity = userEntity.getUserSettings();
        }
        boolean posterView = settingsController.getDisplayMode(userSettingsEntity).equals(DisplayModeEnum.POSTER);
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
                        label(title).withClass("overviewLabel"),
                        br(),
                        SortByFormComponent.render(),
                        iff(cards.size() > 0,
                            LeftFormsComponent.render(type)
                        ),
                        br(),
                        br(),
                        br(),
                        div(
                            iffElse(cards.size() > 0,
                                iffElse(posterView,
                                    each(cards, card -> PosterViewComponent.render(card, size)),
                                    TableViewComponent.render(cards)
                                ),
                                label("Nothing to show").withClass("subLabel")
                            )
                        ).withClass("container"),
                        br(),
                        br(),
                        iff(cards.size() > 0,
                            div(
                                div().withClass("divider"),
                                PaginationComponent.render(currentPage, maxPage, "/" + function + "/" + type)
                            )
                        )
                    ).withClass("body")
                )
            )
        ).getBytes();
    }
}
