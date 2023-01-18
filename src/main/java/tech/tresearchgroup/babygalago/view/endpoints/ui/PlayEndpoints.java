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
import tech.tresearchgroup.babygalago.controller.endpoints.ui.PlayEndpointsController;

@AllArgsConstructor
public class PlayEndpoints extends AbstractModule {
    private final PlayEndpointsController playEndpointsController;
    private final SettingsController settingsController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/play/book/:id", this::playBook)
            .map(HttpMethod.GET, "/play/game/:id", this::playGame)
            .map(HttpMethod.GET, "/play/movie/:id", this::playMovie)
            .map(HttpMethod.GET, "/play/music/:id", this::playMusic)
            .map(HttpMethod.GET, "/play/tvshow/:id", this::playTvShow);
    }

    private @NotNull Promisable<HttpResponse> playBook(@NotNull HttpRequest httpRequest) {
        try {
            return playEndpointsController.playBook(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> playGame(@NotNull HttpRequest httpRequest) {
        try {
            return playEndpointsController.playGame(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> playMovie(@NotNull HttpRequest httpRequest) {
        try {
            return playEndpointsController.playMovie(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> playMusic(@NotNull HttpRequest httpRequest) {
        try {
            return playEndpointsController.playMusic(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> playTvShow(@NotNull HttpRequest httpRequest) {
        try {
            return playEndpointsController.playTvShow(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }
}
