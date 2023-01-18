package tech.tresearchgroup.babygalago.controller.endpoints.api;

import io.activej.http.HttpRequest;
import io.activej.http.HttpResponse;
import lombok.AllArgsConstructor;
import tech.tresearchgroup.babygalago.controller.controllers.QueueController;
import tech.tresearchgroup.babygalago.controller.controllers.UserController;
import tech.tresearchgroup.palila.controller.BasicController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.enums.QueueTypeEnum;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@AllArgsConstructor
public class QueueEndpointsController extends BasicController {
    private final QueueController queueController;
    private final UserController userController;

    public HttpResponse getTask(QueueTypeEnum queueTypeEnum, HttpRequest httpRequest) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        if (canAccess(httpRequest, PermissionGroupEnum.OPERATOR, userController)) {
            boolean returnThis = false;
            if (queueTypeEnum == QueueTypeEnum.CONVERTER) {
                returnThis = queueController.isConverterQueueRunning();
            }
            if (returnThis) {
                return ok();
            } else {
                return error();
            }
        }
        return unauthorized();
    }

    public HttpResponse putTask(QueueTypeEnum queueTypeEnum, HttpRequest httpRequest) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        if (canAccess(httpRequest, PermissionGroupEnum.OPERATOR, userController)) {
            boolean returnThis = false;
            if (queueTypeEnum == QueueTypeEnum.CONVERTER) {
                returnThis = queueController.startConverterQueue();
            }
            if (returnThis) {
                return ok();
            } else {
                return error();
            }
        }
        return unauthorized();
    }

    public HttpResponse deleteTask(QueueTypeEnum queueTypeEnum, HttpRequest httpRequest) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        if (canAccess(httpRequest, PermissionGroupEnum.OPERATOR, userController)) {
            boolean returnThis = false;
            if (queueTypeEnum == QueueTypeEnum.CONVERTER) {
                returnThis = queueController.stopConverterQueue();
            }
            if (returnThis) {
                return ok();
            } else {
                return error();
            }
        }
        return unauthorized();
    }
}
