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
import tech.tresearchgroup.babygalago.controller.endpoints.ui.BrowseEndpointsController;

@AllArgsConstructor
public class BrowseEndpoints extends AbstractModule {
    private final BrowseEndpointsController browseEndpointsController;
    private final SettingsController settingsController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/browse/book", this::browseBook)
            .map(HttpMethod.GET, "/browse/game", this::browseGame)
            .map(HttpMethod.GET, "/browse/movie", this::browseMovie)
            .map(HttpMethod.GET, "/browse/music", this::browseMusic)
            .map(HttpMethod.GET, "/browse/tvshow", this::browseTvShow);
    }

    private @NotNull Promisable<HttpResponse> browseBook(@NotNull HttpRequest httpRequest) {
        try {
            return browseEndpointsController.browseBook(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> browseGame(@NotNull HttpRequest httpRequest) {
        try {
            return browseEndpointsController.browseGame(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> browseMovie(@NotNull HttpRequest httpRequest) {
        try {
            return browseEndpointsController.browseMovie(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> browseMusic(@NotNull HttpRequest httpRequest) {
        try {
            return browseEndpointsController.browseMusic(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> browseTvShow(@NotNull HttpRequest httpRequest) {
        try {
            return browseEndpointsController.browseTvShow(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }
}
