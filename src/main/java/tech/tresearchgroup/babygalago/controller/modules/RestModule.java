package tech.tresearchgroup.babygalago.controller.modules;


import com.google.gson.Gson;
import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.controller.controllers.*;
import tech.tresearchgroup.babygalago.controller.endpoints.AssetEndpointController;
import tech.tresearchgroup.babygalago.controller.endpoints.api.*;
import tech.tresearchgroup.babygalago.controller.endpoints.ui.*;
import tech.tresearchgroup.babygalago.view.endpoints.api.*;
import tech.tresearchgroup.babygalago.view.endpoints.ui.*;
import tech.tresearchgroup.colobus.controller.IndexController;

public class RestModule extends AbstractModule {
    @Provides
    RatingEndpoints ratingEndpoints(RatingController ratingController, SettingsController settingsController) {
        return new RatingEndpoints(ratingController, settingsController);
    }

    @Provides
    GeneralEndpoints generalEndpoints(GeneralEndpointsController generalEndpointsController,
                                      RatingController ratingController,
                                      AlbumController albumController,
                                      ArtistController artistController,
                                      BookController bookController,
                                      CharacterController characterController,
                                      CompanyController companyController,
                                      GameEngineController gameEngineController,
                                      GameController gameController,
                                      GamePlatformReleaseController gamePlatformReleaseController,
                                      GameSeriesController gameSeriesController,
                                      ImageController imageController,
                                      LocationController locationController,
                                      LyricsController lyricsController,
                                      MovieController movieController,
                                      PersonController personController,
                                      SeasonController seasonController,
                                      SongController songController,
                                      SubtitleController subtitleController,
                                      TvShowController tvShowController,
                                      VideoController videoController,
                                      SettingsController settingsController) {
        return new GeneralEndpoints(
            generalEndpointsController,
            ratingController,
            albumController,
            artistController,
            bookController,
            characterController,
            companyController,
            gameEngineController,
            gameController,
            gamePlatformReleaseController,
            gameSeriesController,
            imageController,
            locationController,
            lyricsController,
            movieController,
            personController,
            seasonController,
            songController,
            subtitleController,
            tvShowController,
            videoController,
            settingsController
        );
    }

    @Provides
    MediaTypeEndpoints mediaTypeEndpoints(AlbumController albumController,
                                          ArtistController artistController,
                                          BookController bookController,
                                          CharacterController characterController,
                                          CompanyController companyController,
                                          GameController gameController,
                                          GameEngineController gameEngineController,
                                          GamePlatformReleaseController gamePlatformReleaseController,
                                          GameSeriesController gameSeriesController,
                                          ImageController imageController,
                                          LocationController locationController,
                                          LyricsController lyricsController,
                                          MovieController movieController,
                                          PersonController personController,
                                          SeasonController seasonController,
                                          SongController songController,
                                          SubtitleController subtitleController,
                                          TvShowController tvShowController,
                                          VideoController videoController,
                                          RatingController ratingController,
                                          SettingsController settingsController) {
        return new MediaTypeEndpoints(
            albumController,
            artistController,
            bookController,
            characterController,
            companyController,
            gameController,
            gameEngineController,
            gamePlatformReleaseController,
            gameSeriesController,
            imageController,
            locationController,
            lyricsController,
            movieController,
            personController,
            seasonController,
            songController,
            subtitleController,
            tvShowController,
            videoController,
            ratingController,
            settingsController
        );
    }

    @Provides
    NewsEndpoints newsEndpoints(NewsArticleController newsArticleController, SettingsController settingsController) {
        return new NewsEndpoints(newsArticleController, settingsController);
    }

    @Provides
    NotificationsEndpoints notificationsEndpoints(NotificationController notificationController, SettingsController settingsController) {
        return new NotificationsEndpoints(notificationController, settingsController);
    }

    @Provides
    QueueEndpoints queueEndpoints(QueueEndpointsController queueEndpointsController) {
        return new QueueEndpoints(queueEndpointsController);
    }

    @Provides
    SettingsEndpoints settingsEndpoints(UserSettingsController userSettingsController,
                                        SettingsEndpointsController settingsEndpointsController,
                                        SettingsController settingsController,
                                        UserController userController) {
        return new SettingsEndpoints(userSettingsController, settingsEndpointsController, settingsController, userController);
    }

    @Provides
    UserEndpoints userEndpoints(UserController userController, SettingsController settingsController) {
        return new UserEndpoints(userController, settingsController);
    }

    @Provides
    LoginEndpoints loginEndpoints(LoginEndpointsController loginEndpointsController, SettingsController settingsController, Gson gson) {
        return new LoginEndpoints(loginEndpointsController, settingsController, gson);
    }

    @Provides
    AddEndpoints addEndpoints(AddEndpointsController addEndpointsController, SettingsController settingsController) {
        return new AddEndpoints(addEndpointsController, settingsController);
    }

    @Provides
    BrowseEndpoints browseEndpoints(BrowseEndpointsController browseEndpointsController, SettingsController settingsController) {
        return new BrowseEndpoints(browseEndpointsController, settingsController);
    }

    @Provides
    EditEndpoints editEndpoints(EditEndpointsController editEndpointsController, SettingsController settingsController) {
        return new EditEndpoints(editEndpointsController, settingsController);
    }

    @Provides
    MainEndpoints mainEndpoints(MainEndpointsController mainEndpointsController, IndexController indexController, SettingsController settingsController) {
        return new MainEndpoints(mainEndpointsController, indexController, settingsController);
    }

    @Provides
    NewEndpoints nouveauEndpoints(NewEndpointsController newEndpointsController, SettingsController settingsController) {
        return new NewEndpoints(newEndpointsController, settingsController);
    }

    @Provides
    PlayEndpoints playEndpoints(PlayEndpointsController playEndpointsController, SettingsController settingsController) {
        return new PlayEndpoints(playEndpointsController, settingsController);
    }

    @Provides
    PopularEndpoints popularEndpoints(PopularEndpointsController popularEndpointsController, SettingsController settingsController) {
        return new PopularEndpoints(popularEndpointsController, settingsController);
    }

    @Provides
    ViewEndpoints viewEndpoints(ViewEndpointsController viewEndpointsController, SettingsController settingsController) {
        return new ViewEndpoints(viewEndpointsController, settingsController);
    }

    @Provides
    AssetEndpoint assetEndpoint(AssetEndpointController assetEndpointController, SettingsController settingsController) {
        return new AssetEndpoint(assetEndpointController, settingsController);
    }

    @Provides
    TaskEndpoints taskEndpoints(TaskEndpointsController taskEndpointsController) {
        return new TaskEndpoints(taskEndpointsController);
    }

    @Provides
    UIUserEndpoints uiUserEndpoints(UserSettingsController userSettingsController, SettingsController settingsController) {
        return new UIUserEndpoints(userSettingsController, settingsController);
    }
}
