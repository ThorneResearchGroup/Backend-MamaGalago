package tech.tresearchgroup.babygalago.view.endpoints.api;

import io.activej.http.*;
import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;
import io.activej.promise.Promisable;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import tech.tresearchgroup.babygalago.controller.endpoints.api.QueueEndpointsController;
import tech.tresearchgroup.schemas.galago.enums.QueueTypeEnum;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@AllArgsConstructor
public class QueueEndpoints extends AbstractModule {
    private final QueueEndpointsController queueEndpointsController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/v1/queue/:queueType", this::getQueue)
            .map(HttpMethod.PUT, "/v1/queue/:queueType", this::putQueue)
            .map(HttpMethod.DELETE, "/v1/queue/:queueType", this::deleteQueue)
            .map(HttpMethod.OPTIONS, "/v1/queue/:queueType", this::optionsQueue);
    }

    private @NotNull Promisable<HttpResponse> getQueue(@NotNull HttpRequest httpRequest) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        String baseMediaType = httpRequest.getPathParameter("queueType").toUpperCase();
        QueueTypeEnum queueTypeEnum = Enum.valueOf(QueueTypeEnum.class, baseMediaType);
        return queueEndpointsController.getTask(queueTypeEnum, httpRequest);
    }

    private @NotNull Promisable<HttpResponse> putQueue(@NotNull HttpRequest httpRequest) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        String baseMediaType = httpRequest.getPathParameter("queueType").toUpperCase();
        QueueTypeEnum queueTypeEnum = Enum.valueOf(QueueTypeEnum.class, baseMediaType);
        return queueEndpointsController.putTask(queueTypeEnum, httpRequest);
    }

    private @NotNull Promisable<HttpResponse> deleteQueue(@NotNull HttpRequest httpRequest) throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        String baseMediaType = httpRequest.getPathParameter("queueType").toUpperCase();
        QueueTypeEnum queueTypeEnum = Enum.valueOf(QueueTypeEnum.class, baseMediaType);
        return queueEndpointsController.deleteTask(queueTypeEnum, httpRequest);
    }

    private @NotNull Promisable<HttpResponse> optionsQueue(@NotNull HttpRequest httpRequest) {
        return HttpResponse.ok200().withHeader(HttpHeaders.ALLOW, HttpHeaderValue.of("GET, PUT, DELETE"));
    }
}
