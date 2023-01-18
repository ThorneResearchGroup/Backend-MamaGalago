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
import tech.tresearchgroup.babygalago.controller.endpoints.ui.EditEndpointsController;

@AllArgsConstructor
public class EditEndpoints extends AbstractModule {
    private final EditEndpointsController editEndpointsController;
    private final SettingsController settingsController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/edit/book/:id", this::editBook)
            .map(HttpMethod.GET, "/edit/game/:id", this::editGame)
            .map(HttpMethod.GET, "/edit/movie/:id", this::editMovie)
            .map(HttpMethod.POST, "/edit/movie/:id", this::postEditMovie)
            .map(HttpMethod.GET, "/edit/music/:id", this::editMusic)
            .map(HttpMethod.GET, "/edit/tvshow/:id", this::editTvShow)
            .map(HttpMethod.GET, "/edit/album/:id", this::editAlbum)
            .map(HttpMethod.GET, "/edit/artist/:id", this::editArtist)
            .map(HttpMethod.GET, "/edit/character/:id", this::editCharacter)
            .map(HttpMethod.GET, "/edit/company/:id", this::editCompany)
            .map(HttpMethod.GET, "/edit/episode/:id", this::editEpisode)
            .map(HttpMethod.GET, "/edit/gameengine/:id", this::editGameEngine)
            .map(HttpMethod.GET, "/edit/gameplatformrelease/:id", this::editGamePlatformRelease)
            .map(HttpMethod.GET, "/edit/gameseries/:id", this::editGameSeries)
            .map(HttpMethod.GET, "/edit/location/:id", this::editLocation)
            .map(HttpMethod.GET, "/edit/person/:id", this::editPerson)
            .map(HttpMethod.GET, "/edit/season/:id", this::editSeason);
    }

    private @NotNull Promisable<HttpResponse> editBook(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editBook(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editGame(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editGame(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editMovie(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editMovie(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> postEditMovie(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.postEditMovie(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editMusic(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editMusic(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editTvShow(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editTvShow(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editAlbum(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editAlbum(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editArtist(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editArtist(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editCharacter(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editCharacter(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editCompany(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editCompany(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editEpisode(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editEpisode(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editGameEngine(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editGameEngine(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editGamePlatformRelease(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editGamePlatformRelease(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editGameSeries(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editGameSeries(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editLocation(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editLocation(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editPerson(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editPerson(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> editSeason(@NotNull HttpRequest httpRequest) {
        try {
            return editEndpointsController.editSeason(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }
}
