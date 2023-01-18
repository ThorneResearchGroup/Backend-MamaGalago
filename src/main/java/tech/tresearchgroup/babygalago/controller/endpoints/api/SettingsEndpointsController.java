package tech.tresearchgroup.babygalago.controller.endpoints.api;

import io.activej.http.HttpRequest;
import io.activej.http.HttpResponse;
import lombok.AllArgsConstructor;
import tech.tresearchgroup.babygalago.controller.controllers.UserController;
import tech.tresearchgroup.palila.controller.BasicController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

@AllArgsConstructor
public class SettingsEndpointsController extends BasicController {
    private final UserController userController;

    public HttpResponse getSettings(HttpRequest httpRequest) throws IOException, SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        if (canAccess(httpRequest, PermissionGroupEnum.OPERATOR, userController)) {
            return ok(Files.readAllBytes(Path.of("Settings.json")));
        }
        return unauthorized();
    }
}
