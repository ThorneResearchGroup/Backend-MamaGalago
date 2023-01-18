package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.SeasonEntity;

import com.zaxxer.hikari.HikariDataSource;

public class SeasonController extends GenericController {
    public SeasonController(HikariDataSource hikariDataSource,
                            Gson gson,
                            Client client,
                            BinarySerializer<SeasonEntity> serializer,
                            int reindexSize,
                            Object sample,
                            UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            SeasonEntity.class,
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
