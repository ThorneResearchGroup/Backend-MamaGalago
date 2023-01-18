package tech.tresearchgroup.babygalago.view.components.forms;

import io.activej.http.HttpRequest;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import tech.tresearchgroup.babygalago.controller.CardConverter;
import tech.tresearchgroup.babygalago.controller.ChipsConverter;
import tech.tresearchgroup.babygalago.controller.EnumController;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.controller.controllers.NotificationController;
import tech.tresearchgroup.babygalago.controller.controllers.QueueController;
import tech.tresearchgroup.babygalago.view.components.EditableScrollingComponent;
import tech.tresearchgroup.babygalago.view.components.HeadComponent;
import tech.tresearchgroup.babygalago.view.components.SideBarComponent;
import tech.tresearchgroup.babygalago.view.components.TopBarComponent;
import tech.tresearchgroup.palila.controller.components.*;
import tech.tresearchgroup.palila.controller.generators.UploadScriptGenerator;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.babygalago.model.ExtendedUserEntity;
import tech.tresearchgroup.schemas.galago.entities.*;
import tech.tresearchgroup.schemas.galago.ui.Card;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import static j2html.TagCreator.*;

@AllArgsConstructor
public class MovieForm {
    private final SettingsController settingsController;
    private final NotificationController notificationsController;

    public byte @NotNull [] render(boolean editable,
                                   boolean loggedIn,
                                   int size,
                                   String saveUrl,
                                   ExtendedUserEntity userEntity) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return render(editable, loggedIn, size, saveUrl, null, userEntity, null, null, null, null, null, null, null, null, null, null);
    }

    public byte @NotNull [] render(boolean editable,
                                   boolean loggedIn,
                                   int size,
                                   String saveUrl,
                                   MovieEntity movieEntity,
                                   ExtendedUserEntity userEntity,
                                   FileEntity primaryImageFile,
                                   FileEntity trailerFile,
                                   List<SubtitleEntity> subtitles,
                                   List<CompanyEntity> companyList,
                                   List<VideoEntity> videoList,
                                   List<ImageEntity> imageEntityList,
                                   List<VideoEntity> otherVideosList,
                                   List<PersonEntity> directorsList,
                                   List<PersonEntity> writersList,
                                   List<PersonEntity> castList) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Long id = null;
        String title = null;
        String primaryImage = null;
        String trailer = null;
        String releaseDate = null;
        String runTime = null;
        String mpaaRatings = null;
        String userRating = null;
        String genre = null;
        String productionCompany = null;
        String storyLine = null;
        String languages = null;
        String budget = null;
        String americasGross = null;
        String worldWideGross = null;
        String americasOpeningWeekendGross = null;
        String aspectRatio = null;
        String countryOfOrigin = null;
        List<Card> files = null;
        List<Card> otherImages = null;
        List<Card> otherVideos = null;
        List<Card> directors = null;
        List<Card> writers = null;
        List<Card> cast = null;

        PermissionGroupEnum permissionGroupEnum = PermissionGroupEnum.ALL;
        if (userEntity != null) {
            permissionGroupEnum = userEntity.getPermissionGroup();
        }

        if (movieEntity != null) {
            id = movieEntity.getId();
            title = movieEntity.getTitle();
            if (primaryImageFile != null) {
                primaryImage = primaryImageFile.getPath();
            }
            if (trailerFile != null) {
                trailer = trailerFile.getPath();
            }
            releaseDate = movieEntity.getReleaseDate();
            runTime = String.valueOf(movieEntity.getRuntime());
            if (movieEntity.getMpaaRating() != null) {
                mpaaRatings = movieEntity.getMpaaRating().name();
            }
            userRating = String.valueOf(movieEntity.getUserRating());
            genre = String.valueOf(movieEntity.getGenre());
            StringBuilder productionStringBuilder = new StringBuilder();
            if (movieEntity.getProductionCompany() != null) {
                if (movieEntity.getProductionCompany().size() > 0) {
                    for (CompanyEntity company : companyList) {
                        productionStringBuilder.append(company.getName());
                    }
                }
            }
            productionCompany = productionStringBuilder.toString();
            storyLine = movieEntity.getStoryLine();
            languages = movieEntity.getLanguages();
            budget = String.valueOf(movieEntity.getBudget());
            americasGross = String.valueOf(movieEntity.getAmericasGross());
            worldWideGross = String.valueOf(movieEntity.getWorldWideGross());
            americasOpeningWeekendGross = String.valueOf(movieEntity.getAmericasOpeningWeekend());
            aspectRatio = movieEntity.getAspectRatio();
            countryOfOrigin = String.valueOf(movieEntity.getCountryOfOrigin());
            files = CardConverter.convertVideos(videoList, "view");
            otherImages = CardConverter.convertImages(imageEntityList, "view");
            otherVideos = CardConverter.convertVideos(otherVideosList, "view");
            directors = CardConverter.convertPeople(directorsList, "view");
            writers = CardConverter.convertPeople(writersList, "view");
            cast = CardConverter.convertPeople(castList, "view");
        }
        return document(
            html(
                HeadComponent.render(settingsController.getServerName()),
                TopBarComponent.render(notificationsController.getNumberOfUnread(userEntity), QueueController.getQueueSize(), loggedIn, permissionGroupEnum),
                SideBarComponent.render(loggedIn,
                    settingsController.isMovieLibraryEnable(),
                    settingsController.isTvShowLibraryEnable(),
                    settingsController.isGameLibraryEnable(),
                    settingsController.isMusicLibraryEnable(),
                    settingsController.isBookLibraryEnable()),
                script().withSrc("/assets/autocompletetextbox.js"),
                body(
                    div(
                        form(
                            input().withType("text").withValue(String.valueOf(id)).withName("id").isHidden(),
                            EditableTitleComponent.render(editable, title, "title"),
                            br(),
                            br(),
                            iff(!editable,
                                a(" Edit").withClass("floatRight btn fas fa-edit").withHref("/edit/movie/" + id)
                            ),
                            br(),
                            br(),
                            a("Show trailer").withClass("btn btn-primary").withHref("#trailer-modal"),
                            ModalComponent.render(
                                title + " - Trailer",
                                video(
                                    source().withSrc(trailer).withType("video/mp4"),
                                    text("Your browser does not support the video tag.")
                                ).isControls().withHeight("100%").withWidth("100%"),
                                "trailer-modal"
                            ),
                            br(),
                            br(),
                            div().withId("primaryImageDisplay").withClass("divCenter"),
                            br(),
                            br(),
                            EditableFieldComponent.render(editable, "Primary Image:", primaryImage, "primaryImage"),
                            UploadComponent.render(editable, null, "primaryImage", "/upload"),
                            script(UploadScriptGenerator.getUploadImageDisplayScript("primaryImage", "primaryImageDisplay")),
                            br(),
                            ChipsComponent.render(editable, "Subtitles:", ChipsConverter.convertSubtitles(subtitles), "subtitles"),
                            br(),
                            DatePickerComponent.render(editable, "Release Date:", releaseDate, "releaseDate"),
                            br(),
                            EditableFieldComponent.render(editable, "Run Time:", runTime, "runTime"),
                            br(),
                            AutoCompleteDropDownBoxComponent.render(editable, "MPAA Ratings: ", "mpaaRatings", mpaaRatings, EnumController.getMpaaValues()),
                            br(),
                            StarsComponent.render(editable, "User Ratings:", userRating, "userRating"),
                            br(),
                            AutoCompleteDropDownBoxComponent.render(editable, "Genre: ", "genre", genre, EnumController.getMovieGenres()),
                            br(),
                            AutoCompleteDropDownBoxComponent.render(editable, "Production Company:", productionCompany, "productionCompany", "v1/company/search"),
                            TextAreaComponent.render(editable, "Story Line:", storyLine, "storyLine", "4", "50"),
                            br(),
                            AutoCompleteDropDownBoxComponent.render(editable, "Languages: ", "languages", languages, EnumController.getLanguagesValues()),
                            br(),
                            EditableFieldComponent.render(editable, "Budget:", budget, "budget"),
                            br(),
                            EditableFieldComponent.render(editable, "Americas Gross:", americasGross, "americasGross"),
                            br(),
                            EditableFieldComponent.render(editable, "Worldwide Gross:", worldWideGross, "worldWideGross"),
                            br(),
                            EditableFieldComponent.render(editable, "Americas Opening Weekend Gross:", americasOpeningWeekendGross, "americasOpeningWeekendGross"),
                            br(),
                            EditableFieldComponent.render(editable, "Aspect Ratio:", aspectRatio, "aspectRatio"),
                            br(),
                            AutoCompleteDropDownBoxComponent.render(editable, "Country of origin: ", "countryOfOrigin", countryOfOrigin, EnumController.getCountryValues()),
                            br(),
                            br(),
                            EditableScrollingComponent.render(editable, "Files:", files, "/add/video", size),
                            br(),
                            EditableScrollingComponent.render(editable, "Images:", otherImages, "/add/image", size),
                            br(),
                            EditableScrollingComponent.render(editable, "Videos:", otherVideos, "/add/video", size),
                            br(),
                            EditableScrollingComponent.render(editable, "Directors:", directors, "/add/person", size),
                            br(),
                            EditableScrollingComponent.render(editable, "Writers:", writers, "/add/person", size),
                            br(),
                            EditableScrollingComponent.render(editable, "Cast:", cast, "/add/person", size),
                            br(),
                            br(),
                            iff(editable,
                                button("Save").withClass("floatRight")
                            )
                        )
                            .withAction(saveUrl)
                            .withMethod("POST")
                    ).withClass("body")
                )
            )
        ).getBytes();
    }

    public static MovieEntity getFromForm(HttpRequest httpRequest) {
        return null;
    }
}
