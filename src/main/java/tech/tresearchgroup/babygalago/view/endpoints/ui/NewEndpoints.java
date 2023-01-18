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
import tech.tresearchgroup.babygalago.controller.endpoints.ui.NewEndpointsController;

@AllArgsConstructor
public class NewEndpoints extends AbstractModule {
    private final NewEndpointsController newEndpointsController;
    private final SettingsController settingsController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/new/book", this::newBook)
            .map(HttpMethod.GET, "/new/game", this::newGame)
            .map(HttpMethod.GET, "/new/movie", this::newMovie)
            .map(HttpMethod.GET, "/new/music", this::newMusic)
            .map(HttpMethod.GET, "/new/tvshow", this::newTvShow);
    }

    private @NotNull Promisable<HttpResponse> newBook(@NotNull HttpRequest httpRequest) {
        try {
            return newEndpointsController.newBook(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> newGame(@NotNull HttpRequest httpRequest) {
        try {
            return newEndpointsController.newGame(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> newMovie(@NotNull HttpRequest httpRequest) {
        try {
            return newEndpointsController.newMovie(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> newMusic(@NotNull HttpRequest httpRequest) {
        try {
            return newEndpointsController.newMusic(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> newTvShow(@NotNull HttpRequest httpRequest) {
        try {
            return newEndpointsController.newTvShow(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }
}
