package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.TvShowEntity;

import com.zaxxer.hikari.HikariDataSource;

public class TvShowController extends GenericController {
    public TvShowController(HikariDataSource hikariDataSource,
                            Gson gson,
                            Client client,
                            BinarySerializer<TvShowEntity> serializer,
                            int reindexSize,
                            Object sample,
                            UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            TvShowEntity.class,
            serializer,
            reindexSize,
            "title",
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
