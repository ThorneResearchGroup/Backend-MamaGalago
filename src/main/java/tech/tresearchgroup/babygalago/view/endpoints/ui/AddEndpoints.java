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
import tech.tresearchgroup.babygalago.controller.endpoints.ui.AddEndpointsController;

@AllArgsConstructor
public class AddEndpoints extends AbstractModule {
    private final AddEndpointsController addEndpointsController;
    private final SettingsController settingsController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/add/book", this::addBook)
            .map(HttpMethod.GET, "/add/game", this::addGame)
            .map(HttpMethod.GET, "/add/movie", this::addMovie)
            .map(HttpMethod.GET, "/add/music", this::addMusic)
            .map(HttpMethod.GET, "/add/tvshow", this::addTvShow)
            .map(HttpMethod.GET, "/add/album", this::addAlbum)
            .map(HttpMethod.GET, "/add/artist", this::addArtist)
            .map(HttpMethod.GET, "/add/character", this::addCharacter)
            .map(HttpMethod.GET, "/add/company", this::addCompany)
            .map(HttpMethod.GET, "/add/episode", this::addEpisode)
            .map(HttpMethod.GET, "/add/gameengine", this::addGameEngine)
            .map(HttpMethod.GET, "/add/gameplatformrelease", this::addGamePlatformRelease)
            .map(HttpMethod.GET, "/add/gameseries", this::addGameSeries)
            .map(HttpMethod.GET, "/add/image", this::addImage)
            .map(HttpMethod.GET, "/add/location", this::addLocation)
            .map(HttpMethod.GET, "/add/lyrics", this::addLyrics)
            .map(HttpMethod.GET, "/add/person", this::addPerson)
            .map(HttpMethod.GET, "/add/season", this::addSeason)
            .map(HttpMethod.GET, "/add/subtitle", this::addSubtitle)
            .map(HttpMethod.GET, "/add/video", this::addVideo);
    }

    private @NotNull Promisable<HttpResponse> addBook(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addBook(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addGame(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addGame(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addMovie(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addMovie(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addMusic(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addMusic(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addTvShow(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addTvShow(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addAlbum(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addAlbum(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addArtist(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addArtist(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addCharacter(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addCharacter(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addCompany(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addCompany(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addEpisode(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addEpisode(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addGameEngine(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addGameEngine(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addGamePlatformRelease(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addGamePlatformRelease(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addGameSeries(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addGameSeries(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addImage(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addImage(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addLocation(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addLocation(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addLyrics(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addLyrics(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addPerson(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addPerson(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addSeason(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addSeason(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addSubtitle(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addSubtitle(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> addVideo(@NotNull HttpRequest httpRequest) {
        try {
            return addEndpointsController.addVideo(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }
}
