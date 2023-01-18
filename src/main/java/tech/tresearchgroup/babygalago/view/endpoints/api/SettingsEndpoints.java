package tech.tresearchgroup.babygalago.view.endpoints.api;

import io.activej.http.*;
import io.activej.inject.annotation.Provides;
import io.activej.promise.Promisable;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.controller.controllers.UserSettingsController;
import tech.tresearchgroup.babygalago.controller.endpoints.api.SettingsEndpointsController;
import tech.tresearchgroup.palila.controller.BasicController;
import tech.tresearchgroup.palila.controller.BasicUserController;

import java.nio.charset.Charset;
import java.util.Objects;

@AllArgsConstructor
public class SettingsEndpoints extends BasicController {
    private final UserSettingsController userSettingsController;
    private final SettingsEndpointsController settingsEndpointsController;
    private final SettingsController settingsController;
    private final BasicUserController userController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/v1/settings", this::getSettings)
            .map(HttpMethod.PATCH, "/v1/settings", this::patchSettings)
            .map(HttpMethod.OPTIONS, "/v1/settings", this::optionsSettings)
            .map(HttpMethod.GET, "/v1/user/settings", this::getUserSettings)
            .map(HttpMethod.POST, "/v1/user/settings", this::createUserSettings)
            .map(HttpMethod.PATCH, "/v1/user/settings", this::patchUserSettings)
            .map(HttpMethod.DELETE, "/v1/user/settings", this::deleteUserSettings)
            .map(HttpMethod.OPTIONS, "/v1/user/settings", this::optionsSettingsById);
    }

    private @NotNull Promisable<HttpResponse> getSettings(@NotNull HttpRequest httpRequest) {
        try {
            return settingsEndpointsController.getSettings(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> patchSettings(@NotNull HttpRequest httpRequest) {
        String jwt = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);
        //Todo implement
        return HttpResponse.ok200();
    }

    private @NotNull Promisable<HttpResponse> optionsSettings(@NotNull HttpRequest httpRequest) {
        return HttpResponse.ok200().withHeader(HttpHeaders.ALLOW, HttpHeaderValue.of("GET, PATCH"));
    }

    private @NotNull Promisable<HttpResponse> getUserSettings(@NotNull HttpRequest httpRequest) {
        try {
            long userId = userController.getUserId(httpRequest);
            return okResponseCompressed(userSettingsController.readSecureAPIResponse(userId, httpRequest));
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> createUserSettings(@NotNull HttpRequest httpRequest) {
        try {
            String data = httpRequest.loadBody().getResult().asString(Charset.defaultCharset());
            return okResponseCompressed(userSettingsController.createSecureAPIResponse(data, httpRequest));
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> patchUserSettings(@NotNull HttpRequest httpRequest) {
        try {
            String data = httpRequest.loadBody().getResult().asString(Charset.defaultCharset());
            long userId = getUserId(httpRequest);
            return ok(userSettingsController.update(userId, data, httpRequest));
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> deleteUserSettings(@NotNull HttpRequest httpRequest) {
        try {
            int settingsId = httpRequest.getQueryParameter("settingsId") != null ? Integer.parseInt(Objects.requireNonNull(httpRequest.getQueryParameter("settingsId"))) : 0;
            return ok(userSettingsController.delete(settingsId, httpRequest));
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> optionsSettingsById(@NotNull HttpRequest httpRequest) {
        return HttpResponse.ok200().withHeader(HttpHeaders.ALLOW, HttpHeaderValue.of("GET, POST, PATCH, DELETE"));
    }
}
