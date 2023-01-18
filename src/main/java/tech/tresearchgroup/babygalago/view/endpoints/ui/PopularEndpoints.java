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
import tech.tresearchgroup.babygalago.controller.endpoints.ui.PopularEndpointsController;

@AllArgsConstructor
public class PopularEndpoints extends AbstractModule {
    private final PopularEndpointsController popularEndpointsController;
    private final SettingsController settingsController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/popular/book", this::popularBook)
            .map(HttpMethod.GET, "/popular/game", this::popularGame)
            .map(HttpMethod.GET, "/popular/movie", this::popularMovie)
            .map(HttpMethod.GET, "/popular/music", this::popularMusic)
            .map(HttpMethod.GET, "/popular/tvshow", this::popularTvShow);
    }

    private @NotNull Promisable<HttpResponse> popularBook(@NotNull HttpRequest httpRequest) {
        try {
            return popularEndpointsController.popularBook(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> popularGame(@NotNull HttpRequest httpRequest) {
        try {
            return popularEndpointsController.popularGame(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> popularMovie(@NotNull HttpRequest httpRequest) {
        try {
            return popularEndpointsController.popularMovie(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> popularMusic(@NotNull HttpRequest httpRequest) {
        try {
            return popularEndpointsController.popularMusic(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> popularTvShow(@NotNull HttpRequest httpRequest) {
        try {
            return popularEndpointsController.popularTvShow(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }
}
