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
import tech.tresearchgroup.babygalago.controller.endpoints.ui.ViewEndpointsController;

@AllArgsConstructor
public class ViewEndpoints extends AbstractModule {
    private final ViewEndpointsController viewEndpointsController;
    private final SettingsController settingsController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/view/book/:id", this::viewBook)
            .map(HttpMethod.GET, "/view/game/:id", this::viewGame)
            .map(HttpMethod.GET, "/view/movie/:id", this::viewMovie)
            .map(HttpMethod.GET, "/view/music/:id", this::viewMusic)
            .map(HttpMethod.GET, "/view/tvshow/:id", this::viewTvShow)
            .map(HttpMethod.GET, "/view/album/:id", this::viewAlbum)
            .map(HttpMethod.GET, "/view/artist/:id", this::viewArtist)
            .map(HttpMethod.GET, "/view/character/:id", this::viewCharacter)
            .map(HttpMethod.GET, "/view/company/:id", this::viewCompany)
            .map(HttpMethod.GET, "/view/episode/:id", this::viewEpisode)
            .map(HttpMethod.GET, "/view/gameengine/:id", this::viewGameEngine)
            .map(HttpMethod.GET, "/view/gameplatformrelease/:id", this::viewGamePlatformRelease)
            .map(HttpMethod.GET, "/view/gameseries/:id", this::viewGameSeries)
            .map(HttpMethod.GET, "/view/image/:id", this::viewImage)
            .map(HttpMethod.GET, "/view/location/:id", this::viewLocation)
            .map(HttpMethod.GET, "/view/person/:id", this::viewPerson)
            .map(HttpMethod.GET, "/view/season/:id", this::viewSeason)
            .map(HttpMethod.GET, "/view/subtitle/:id", this::viewSubtitle)
            .map(HttpMethod.GET, "/view/video/:id", this::viewVideo);
    }

    private @NotNull Promisable<HttpResponse> viewBook(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewBook(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewGame(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewGame(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewMovie(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewMovie(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewMusic(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewMusic(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewTvShow(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewTvShow(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewAlbum(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewAlbum(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewArtist(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewArtist(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewCharacter(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewCharacter(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewCompany(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewCompany(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewEpisode(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewEpisode(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewGameEngine(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewGameEngine(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewGamePlatformRelease(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewGamePlatformRelease(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewGameSeries(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewGameSeries(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewImage(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewImage(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewLocation(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewLocation(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewPerson(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewPerson(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewSeason(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewSeason(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewSubtitle(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewSubtitle(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> viewVideo(@NotNull HttpRequest httpRequest) {
        try {
            return viewEndpointsController.viewVideo(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }
}
