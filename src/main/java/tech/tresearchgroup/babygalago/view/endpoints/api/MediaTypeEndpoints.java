package tech.tresearchgroup.babygalago.view.endpoints.api;

import io.activej.http.*;
import io.activej.inject.annotation.Provides;
import io.activej.promise.Promisable;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.controller.controllers.*;
import tech.tresearchgroup.palila.controller.HttpResponses;

import java.nio.charset.Charset;
import java.util.Objects;

@AllArgsConstructor
public class MediaTypeEndpoints extends HttpResponses {
    private final AlbumController albumEndpointsController;
    private final ArtistController artistEndpointsController;
    private final BookController bookEndpointsController;
    private final CharacterController characterEndpointsController;
    private final CompanyController companyEndpointsController;
    private final GameController gameEndpointsController;
    private final GameEngineController gameEngineEndpointsController;
    private final GamePlatformReleaseController gamePlatformReleaseEndpointsController;
    private final GameSeriesController gameSeriesEndpointsController;
    private final ImageController imageEndpointsController;
    private final LocationController locationEndpointsController;
    private final LyricsController lyricsEndpointsController;
    private final MovieController movieEndpointsController;
    private final PersonController personEndpointsController;
    private final SeasonController seasonEndpointsController;
    private final SongController songEndpointsController;
    private final SubtitleController subtitleEndpointsController;
    private final TvShowController tvShowEndpointsController;
    private final VideoController videoEndpointsController;
    private final RatingController ratingEndpointsController;
    private final SettingsController settingsController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/v1/:mediaType", this::getMedia)
            .map(HttpMethod.POST, "/v1/:mediaType", this::postMedia)
            .map(HttpMethod.PUT, "/v1/:mediaType", this::putMedia)
            .map(HttpMethod.OPTIONS, "/v1/:mediaType", this::optionsMediaType)
            .map(HttpMethod.GET, "/v1/:mediaType/sample", this::getMediaSample)
            .map(HttpMethod.PUT, "/v1/:mediaType/deleteindex", this::putDeleteIndex)
            .map(HttpMethod.OPTIONS, "/v1/:mediaType/deleteindex", this::optionsDeleteIndex)
            .map(HttpMethod.PUT, "/v1/:mediaType/reindex", this::putReindex)
            .map(HttpMethod.OPTIONS, "/v1/:mediaType/reindex", this::optionsReIndex)
            .map(HttpMethod.GET, "/v1/:mediaType/search", this::search)
            .map(HttpMethod.OPTIONS, "/v1/:mediaType/search", this::optionsSearch)
            .map(HttpMethod.GET, "/v1/:mediaType/:mediaId", this::getMediaById)
            .map(HttpMethod.PATCH, "/v1/:mediaType/:mediaId", this::patchMediaById)
            .map(HttpMethod.DELETE, "/v1/:mediaType/:mediaId", this::deleteMediaById)
            .map(HttpMethod.OPTIONS, "/v1/:mediaType/:mediaId", this::optionsMediaTypeById)
            .map(HttpMethod.GET, "/v1/:mediaType/:mediaId/ratings", this::getMediaRatings)
            .map(HttpMethod.OPTIONS, "/v1/:mediaType/:mediaId/ratings", this::optionsMediaTypeRatingsById);
    }

    private @NotNull Promisable<HttpResponse> getMedia(@NotNull HttpRequest httpRequest) {
        try {
            String mediaType = httpRequest.getPathParameter("mediaType");
            int page = httpRequest.getQueryParameter("page") != null ? Integer.parseInt(Objects.requireNonNull(httpRequest.getQueryParameter("page"))) : 0;
            int pageSize = httpRequest.getQueryParameter("pageSize") != null ? Integer.parseInt(Objects.requireNonNull(httpRequest.getQueryParameter("pageSize"))) : 0;
            return switch (mediaType) {
                case "album" -> okResponseCompressed(albumEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "artist" -> okResponseCompressed(artistEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "book" -> okResponseCompressed(bookEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "character" -> okResponseCompressed(characterEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "company" -> okResponseCompressed(companyEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "game" -> okResponseCompressed(gameEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "gameengine" -> okResponseCompressed(gameEngineEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "gameplatformrelease" -> okResponseCompressed(gamePlatformReleaseEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "gameseries" -> okResponseCompressed(gameSeriesEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "image" -> okResponseCompressed(imageEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "location" -> okResponseCompressed(locationEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "lyrics" -> okResponseCompressed(lyricsEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "movie" -> okResponseCompressed(movieEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "person" -> okResponseCompressed(personEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "season" -> okResponseCompressed(seasonEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "song" -> okResponseCompressed(songEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "subtitle" -> okResponseCompressed(subtitleEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "tvshow" -> okResponseCompressed(tvShowEndpointsController.readPaginatedAPIResponse(page, pageSize));
                case "video" -> okResponseCompressed(videoEndpointsController.readPaginatedAPIResponse(page, pageSize));
                default -> HttpResponse.ofCode(404);
            };
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> postMedia(@NotNull HttpRequest httpRequest) {
        try {
            String type = httpRequest.getPathParameter("mediaType");
            String data = httpRequest.loadBody().getResult().asString(Charset.defaultCharset());
            return switch (type) {
                case "album" -> ok(albumEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "artist" -> ok(artistEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "book" -> ok(bookEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "character" -> ok(characterEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "company" -> ok(companyEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "game" -> ok(gameEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "gameengine" -> ok(gameEngineEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "gameplatformrelease" -> ok(gamePlatformReleaseEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "gameseries" -> ok(gameSeriesEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "image" -> ok(imageEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "location" -> ok(locationEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "lyrics" -> ok(lyricsEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "movie" -> ok(movieEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "person" -> ok(personEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "season" -> ok(seasonEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "song" -> ok(songEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "subtitle" -> ok(subtitleEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "tvshow" -> ok(tvShowEndpointsController.createSecureAPIResponse(data, httpRequest));
                case "video" -> ok(videoEndpointsController.createSecureAPIResponse(data, httpRequest));
                default -> HttpResponse.ofCode(404);
            };
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> putMedia(@NotNull HttpRequest httpRequest) {
        try {
            String type = httpRequest.getPathParameter("mediaType");
            String data = httpRequest.loadBody().getResult().asString(Charset.defaultCharset());
            return switch (type) {
                case "album" -> ok(albumEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "artist" -> ok(artistEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "book" -> ok(bookEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "character" -> ok(characterEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "company" -> ok(companyEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "game" -> ok(gameEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "gameengine" -> ok(gameEngineEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "gameplatformrelease" -> ok(gamePlatformReleaseEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "gameseries" -> ok(gameSeriesEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "image" -> ok(imageEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "location" -> ok(locationEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "lyrics" -> ok(lyricsEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "movie" -> ok(movieEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "person" -> ok(personEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "season" -> ok(seasonEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "song" -> ok(songEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "subtitle" -> ok(subtitleEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "tvshow" -> ok(tvShowEndpointsController.createSecureResponse(data, httpRequest) != null);
                case "video" -> ok(videoEndpointsController.createSecureResponse(data, httpRequest) != null);
                default -> HttpResponse.ofCode(404);
            };
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> optionsMediaType(@NotNull HttpRequest httpRequest) {
        return HttpResponse.ok200().withHeader(HttpHeaders.ALLOW, HttpHeaderValue.of("GET, POST, PUT"));
    }

    private @NotNull Promisable<HttpResponse> getMediaSample(@NotNull HttpRequest httpRequest) {
        try {
            String type = httpRequest.getPathParameter("mediaType");
            return switch (type) {
                case "album" -> okResponseCompressed(albumEndpointsController.getSample());
                case "artist" -> okResponseCompressed(artistEndpointsController.getSample());
                case "book" -> okResponseCompressed(bookEndpointsController.getSample());
                case "character" -> okResponseCompressed(characterEndpointsController.getSample());
                case "company" -> okResponseCompressed(companyEndpointsController.getSample());
                case "game" -> okResponseCompressed(gameEndpointsController.getSample());
                case "gameengine" -> okResponseCompressed(gameEngineEndpointsController.getSample());
                case "gameplatformrelease" -> okResponseCompressed(gamePlatformReleaseEndpointsController.getSample());
                case "gameseries" -> okResponseCompressed(gameSeriesEndpointsController.getSample());
                case "image" -> okResponseCompressed(imageEndpointsController.getSample());
                case "location" -> okResponseCompressed(locationEndpointsController.getSample());
                case "lyrics" -> okResponseCompressed(lyricsEndpointsController.getSample());
                case "movie" -> okResponseCompressed(movieEndpointsController.getSample());
                case "person" -> okResponseCompressed(personEndpointsController.getSample());
                case "season" -> okResponseCompressed(seasonEndpointsController.getSample());
                case "song" -> okResponseCompressed(songEndpointsController.getSample());
                case "subtitle" -> okResponseCompressed(subtitleEndpointsController.getSample());
                case "tvshow" -> okResponseCompressed(tvShowEndpointsController.getSample());
                case "video" -> okResponseCompressed(videoEndpointsController.getSample());
                default -> HttpResponse.ofCode(404);
            };
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> putDeleteIndex(@NotNull HttpRequest httpRequest) {
        try {
            String type = httpRequest.getPathParameter("mediaType");
            return switch (type) {
                case "album" -> albumEndpointsController.deleteAllIndexes();
                case "artist" -> artistEndpointsController.deleteAllIndexes();
                case "book" -> bookEndpointsController.deleteAllIndexes();
                case "character" -> characterEndpointsController.deleteAllIndexes();
                case "company" -> companyEndpointsController.deleteAllIndexes();
                case "game" -> gameEndpointsController.deleteAllIndexes();
                case "gameengine" -> gameEngineEndpointsController.deleteAllIndexes();
                case "gameplatformrelease" -> gamePlatformReleaseEndpointsController.deleteAllIndexes();
                case "gameseries" -> gameSeriesEndpointsController.deleteAllIndexes();
                case "image" -> imageEndpointsController.deleteAllIndexes();
                case "location" -> locationEndpointsController.deleteAllIndexes();
                case "lyrics" -> lyricsEndpointsController.deleteAllIndexes();
                case "movie" -> movieEndpointsController.deleteAllIndexes();
                case "person" -> personEndpointsController.deleteAllIndexes();
                case "season" -> seasonEndpointsController.deleteAllIndexes();
                case "song" -> songEndpointsController.deleteAllIndexes();
                case "tvshow" -> tvShowEndpointsController.deleteAllIndexes();
                case "video" -> videoEndpointsController.deleteAllIndexes();
                default -> HttpResponse.ofCode(500);
            };
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> optionsDeleteIndex(@NotNull HttpRequest httpRequest) {
        return HttpResponse.ok200().withHeader(HttpHeaders.ALLOW, HttpHeaderValue.of("PUT"));
    }

    private @NotNull Promisable<HttpResponse> putReindex(@NotNull HttpRequest httpRequest) {
        try {
            String type = httpRequest.getPathParameter("mediaType");
            switch (type) {
                case "album" -> ok(albumEndpointsController.reindex());
                case "artist" -> ok(artistEndpointsController.reindex());
                case "book" -> ok(bookEndpointsController.reindex());
                case "character" -> ok(characterEndpointsController.reindex());
                case "company" -> ok(companyEndpointsController.reindex());
                case "game" -> ok(gameEndpointsController.reindex());
                case "gameengine" -> ok(gameEngineEndpointsController.reindex());
                case "gameplatformrelease" -> ok(gamePlatformReleaseEndpointsController.reindex());
                case "gameseries" -> ok(gameSeriesEndpointsController.reindex());
                case "image" -> ok(imageEndpointsController.reindex());
                case "location" -> ok(locationEndpointsController.reindex());
                case "lyrics" -> ok(lyricsEndpointsController.reindex());
                case "movie" -> ok(movieEndpointsController.reindex());
                case "person" -> ok(personEndpointsController.reindex());
                case "season" -> ok(seasonEndpointsController.reindex());
                case "song" -> ok(songEndpointsController.reindex());
                case "tvshow" -> ok(tvShowEndpointsController.reindex());
                case "video" -> ok(videoEndpointsController.reindex());
            }
            return HttpResponse.ok200();
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> optionsReIndex(@NotNull HttpRequest httpRequest) {
        return HttpResponse.ok200().withHeader(HttpHeaders.ALLOW, HttpHeaderValue.of("PUT"));
    }

    private @NotNull Promisable<HttpResponse> search(@NotNull HttpRequest httpRequest) {
        try {
            String type = httpRequest.getPathParameter("mediaType");
            String query = httpRequest.getQueryParameter("q");
            return switch (type) {
                case "album" -> ok(albumEndpointsController.searchAPIResponse(query, "*"));
                case "artist" -> ok(artistEndpointsController.searchAPIResponse(query, "*"));
                case "book" -> ok(bookEndpointsController.searchAPIResponse(query, "*"));
                case "character" -> ok(characterEndpointsController.searchAPIResponse(query, "*"));
                case "company" -> ok(companyEndpointsController.searchAPIResponse(query, "*"));
                case "game" -> ok(gameEndpointsController.searchAPIResponse(query, "*"));
                case "gameengine" -> ok(gameEngineEndpointsController.searchAPIResponse(query, "*"));
                case "gameplatformrelease" -> ok(gamePlatformReleaseEndpointsController.searchAPIResponse(query, "*"));
                case "gameseries" -> ok(gameSeriesEndpointsController.searchAPIResponse(query, "*"));
                case "image" -> ok(imageEndpointsController.searchAPIResponse(query, "*"));
                case "location" -> ok(locationEndpointsController.searchAPIResponse(query, "*"));
                case "lyrics" -> ok(lyricsEndpointsController.searchAPIResponse(query, "*"));
                case "movie" -> ok(movieEndpointsController.searchAPIResponse(query, "*"));
                case "person" -> ok(personEndpointsController.searchAPIResponse(query, "*"));
                case "season" -> ok(seasonEndpointsController.searchAPIResponse(query, "*"));
                case "subtitle" -> ok(subtitleEndpointsController.searchAPIResponse(query, "*"));
                case "song" -> ok(songEndpointsController.searchAPIResponse(query, "*"));
                case "tvshow" -> ok(tvShowEndpointsController.searchAPIResponse(query, "*"));
                case "video" -> ok(videoEndpointsController.searchAPIResponse(query, "*"));
                default -> HttpResponse.notFound404();
            };
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> optionsSearch(@NotNull HttpRequest httpRequest) {
        return HttpResponse.ok200().withHeader(HttpHeaders.ALLOW, HttpHeaderValue.of("GET"));
    }

    private @NotNull Promisable<HttpResponse> getMediaById(@NotNull HttpRequest httpRequest) {
        try {
            String type = httpRequest.getPathParameter("mediaType");
            Long mediaId = Long.parseLong(httpRequest.getPathParameter("mediaId"));
            return switch (type) {
                case "album" -> okResponseCompressed(albumEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "artist" -> okResponseCompressed(artistEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "book" -> okResponseCompressed(bookEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "character" -> okResponseCompressed(characterEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "company" -> okResponseCompressed(companyEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "game" -> okResponseCompressed(gameEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "gameengine" -> okResponseCompressed(gameEngineEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "gameplatformrelease" -> okResponseCompressed(gamePlatformReleaseEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "gameseries" -> okResponseCompressed(gameSeriesEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "image" -> okResponseCompressed(imageEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "location" -> okResponseCompressed(locationEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "lyrics" -> okResponseCompressed(lyricsEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "movie" -> okResponseCompressed(movieEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "person" -> okResponseCompressed(personEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "season" -> okResponseCompressed(seasonEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "song" -> okResponseCompressed(songEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "subtitle" -> okResponseCompressed(subtitleEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "tvshow" -> okResponseCompressed(tvShowEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                case "video" -> okResponseCompressed(videoEndpointsController.readSecureAPIResponse(mediaId, httpRequest));
                default -> HttpResponse.ofCode(404);
            };
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> patchMediaById(@NotNull HttpRequest httpRequest) {
        try {
            String type = httpRequest.getPathParameter("mediaType");
            String data = httpRequest.loadBody().getResult().asString(Charset.defaultCharset());
            Long id = Long.valueOf(httpRequest.getPathParameter("mediaId"));
            return switch (type) {
                case "album" -> ok(albumEndpointsController.update(id, data));
                case "artist" -> ok(artistEndpointsController.update(id, data));
                case "book" -> ok(bookEndpointsController.update(id, data));
                case "character" -> ok(characterEndpointsController.update(id, data));
                case "company" -> ok(companyEndpointsController.update(id, data));
                case "game" -> ok(gameEndpointsController.update(id, data));
                case "gameengine" -> ok(gameEngineEndpointsController.update(id, data));
                case "gameplatformrelease" -> ok(gamePlatformReleaseEndpointsController.update(id, data));
                case "gameseries" -> ok(gameSeriesEndpointsController.update(id, data));
                case "image" -> ok(imageEndpointsController.update(id, data));
                case "location" -> ok(locationEndpointsController.update(id, data));
                case "lyrics" -> ok(lyricsEndpointsController.update(id, data));
                case "movie" -> ok(movieEndpointsController.update(id, data));
                case "person" -> ok(personEndpointsController.update(id, data));
                case "season" -> ok(seasonEndpointsController.update(id, data));
                case "song" -> ok(songEndpointsController.update(id, data));
                case "subtitle" -> ok(subtitleEndpointsController.update(id, data));
                case "tvshow" -> ok(tvShowEndpointsController.update(id, data));
                case "video" -> ok(videoEndpointsController.update(id, data));
                default -> HttpResponse.ofCode(404);
            };
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> deleteMediaById(@NotNull HttpRequest httpRequest) {
        try {
            String type = httpRequest.getPathParameter("mediaType");
            Long mediaId = Long.parseLong(httpRequest.getPathParameter("mediaId"));
            return switch (type) {
                case "album" -> ok(albumEndpointsController.delete(mediaId));
                case "artist" -> ok(artistEndpointsController.delete(mediaId));
                case "book" -> ok(bookEndpointsController.delete(mediaId));
                case "character" -> ok(characterEndpointsController.delete(mediaId));
                case "company" -> ok(companyEndpointsController.delete(mediaId));
                case "game" -> ok(gameEndpointsController.delete(mediaId));
                case "gameengine" -> ok(gameEngineEndpointsController.delete(mediaId));
                case "gameplatformrelease" -> ok(gamePlatformReleaseEndpointsController.delete(mediaId));
                case "gameseries" -> ok(gameSeriesEndpointsController.delete(mediaId));
                case "image" -> ok(imageEndpointsController.delete(mediaId));
                case "location" -> ok(locationEndpointsController.delete(mediaId));
                case "lyrics" -> ok(lyricsEndpointsController.delete(mediaId));
                case "movie" -> ok(movieEndpointsController.delete(mediaId));
                case "person" -> ok(personEndpointsController.delete(mediaId));
                case "season" -> ok(seasonEndpointsController.delete(mediaId));
                case "song" -> ok(songEndpointsController.delete(mediaId));
                case "subtitle" -> ok(subtitleEndpointsController.delete(mediaId));
                case "tvshow" -> ok(tvShowEndpointsController.delete(mediaId));
                case "video" -> ok(videoEndpointsController.delete(mediaId));
                default -> HttpResponse.ofCode(404);
            };
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> optionsMediaTypeById(@NotNull HttpRequest httpRequest) {
        return HttpResponse.ok200().withHeader(HttpHeaders.ALLOW, HttpHeaderValue.of("GET, PATCH, DELETE"));
    }

    private @NotNull Promisable<HttpResponse> getMediaRatings(@NotNull HttpRequest httpRequest) {
        try {
            String type = httpRequest.getPathParameter("mediaType");
            int mediaId = Integer.parseInt(httpRequest.getPathParameter("mediaId"));
            return switch (type) {
                //TODO replace with ENUM
                case "album", "subtitle", "season", "song", "tvshow", "video", "person", "movie", "location", "lyrics",
                    "language", "image", "gameseries", "gameplatformrelease", "gameengine", "company", "book", "artist",
                    "character", "game" -> ratingEndpointsController.getRatings(type, mediaId);
                default -> HttpResponse.ofCode(404);
            };
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> optionsMediaTypeRatingsById(@NotNull HttpRequest httpRequest) {
        return HttpResponse.ok200().withHeader(HttpHeaders.ALLOW, HttpHeaderValue.of("GET"));
    }
}
