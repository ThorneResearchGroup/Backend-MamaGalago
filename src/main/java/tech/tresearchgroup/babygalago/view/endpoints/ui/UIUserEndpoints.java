package tech.tresearchgroup.babygalago.view.endpoints.ui;

import io.activej.http.HttpMethod;
import io.activej.http.HttpRequest;
import io.activej.http.HttpResponse;
import io.activej.http.RoutingServlet;
import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;
import io.activej.promise.Promisable;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.controller.controllers.UserSettingsController;
import tech.tresearchgroup.schemas.galago.entities.UserSettingsEntity;
import tech.tresearchgroup.schemas.galago.enums.DisplayModeEnum;
import tech.tresearchgroup.schemas.galago.enums.InterfaceMethodEnum;
import tech.tresearchgroup.schemas.galago.enums.PlaybackQualityEnum;

import java.util.Objects;

@AllArgsConstructor
public class UIUserEndpoints extends AbstractModule {
    private final UserSettingsController userSettingsController;
    private final SettingsController settingsController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/user/settings", this::getSettings)
            .map(HttpMethod.POST, "/user/settings", this::postSettings);
    }

    private @NotNull Promisable<HttpResponse> getSettings(@NotNull HttpRequest httpRequest) {
        try {
            return userSettingsController.read(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> postSettings(@NotNull HttpRequest httpRequest) {
        try {
            InterfaceMethodEnum interfaceNetworkUsage = InterfaceMethodEnum.valueOf(httpRequest.getPostParameter("interfaceNetworkUsage"));
            PlaybackQualityEnum defaultPlaybackQuality = PlaybackQualityEnum.valueOf(httpRequest.getPostParameter("defaultPlaybackQuality"));
            DisplayModeEnum displayMode = DisplayModeEnum.valueOf(httpRequest.getPostParameter("displayMode"));
            boolean showPoster = Objects.equals(httpRequest.getPostParameter("showPoster"), "on");
            boolean showName = Objects.equals(httpRequest.getPostParameter("showName"), "on");
            boolean showRuntime = Objects.equals(httpRequest.getPostParameter("showRuntime"), "on");
            boolean showGenre = Objects.equals(httpRequest.getPostParameter("showGenre"), "on");
            boolean showMpaaRating = Objects.equals(httpRequest.getPostParameter("showMpaaRating"), "on");
            boolean showUserRating = Objects.equals(httpRequest.getPostParameter("showUserRating"), "on");
            boolean showLanguage = Objects.equals(httpRequest.getPostParameter("showLanguage"), "on");
            boolean showReleaseDate = Objects.equals(httpRequest.getPostParameter("showReleaseDate"), "on");
            boolean showActions = Objects.equals(httpRequest.getPostParameter("showActions"), "on");
            boolean showNewBooks = Objects.equals(httpRequest.getPostParameter("showNewBooks"), "on");
            boolean showNewGames = Objects.equals(httpRequest.getPostParameter("showNewGames"), "on");
            boolean showNewMovies = Objects.equals(httpRequest.getPostParameter("showNewMovies"), "on");
            boolean showNewMusic = Objects.equals(httpRequest.getPostParameter("showNewMusic"), "on");
            boolean showNewTvShows = Objects.equals(httpRequest.getPostParameter("showNewTvShows"), "on");
            boolean showPopularBooks = Objects.equals(httpRequest.getPostParameter("showPopularBooks"), "on");
            boolean showPopularGames = Objects.equals(httpRequest.getPostParameter("showPopularGames"), "on");
            boolean showPopularMovies = Objects.equals(httpRequest.getPostParameter("showPopularMovies"), "on");
            boolean showPopularMusic = Objects.equals(httpRequest.getPostParameter("showPopularMusic"), "on");
            boolean showPopularTvShows = Objects.equals(httpRequest.getPostParameter("showPopularTvShows"), "on");
            int maxSearchResults = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("maxSearchResults")));
            int maxBrowseResults = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("maxBrowseResults")));
            int fontSize = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("fontSize")));
            String fontType = httpRequest.getPostParameter("fontType");
            String fontColor = httpRequest.getPostParameter("fontColor");
            int cardWidth = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("cardWidth")));
            boolean stickyTopMenu = Boolean.parseBoolean(httpRequest.getPostParameter("stickTopMenu"));

            UserSettingsEntity userSettingsEntity = new UserSettingsEntity(
                interfaceNetworkUsage,
                defaultPlaybackQuality,
                displayMode,
                showPoster,
                showName,
                showRuntime,
                showGenre,
                showMpaaRating,
                showUserRating,
                showLanguage,
                showReleaseDate,
                showActions,
                showNewMovies,
                showNewTvShows,
                showNewGames,
                showNewBooks,
                showNewMusic,
                showPopularMovies,
                showPopularTvShows,
                showPopularGames,
                showPopularBooks,
                showPopularMusic,
                maxSearchResults,
                maxBrowseResults,
                fontSize,
                fontType,
                fontColor,
                cardWidth,
                stickyTopMenu
            );

            return userSettingsController.create(
                userSettingsEntity,
                httpRequest
            );
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }
}
