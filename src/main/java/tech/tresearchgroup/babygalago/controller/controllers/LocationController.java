package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.LocationEntity;

import com.zaxxer.hikari.HikariDataSource;

public class LocationController extends GenericController {
    public LocationController(HikariDataSource hikariDataSource,
                              Gson gson,
                              Client client,
                              BinarySerializer<LocationEntity> serializer,
                              int reindexSize,
                              Object sample,
                              UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            LocationEntity.class,
            serializer,
            reindexSize,
            "name",
            sample,
            PermissionGroupEnum.USER,
            PermissionGroupEnum.USER,
            PermissionGroupEnum.USER,
            PermissionGroupEnum.USER,
            PermissionGroupEnum.USER,
            userController
        );
    }
}
