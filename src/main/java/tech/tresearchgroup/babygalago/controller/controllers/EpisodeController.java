package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.EpisodeEntity;

import com.zaxxer.hikari.HikariDataSource;

public class EpisodeController extends GenericController {
    public EpisodeController(HikariDataSource hikariDataSource,
                             Gson gson,
                             Client client,
                             BinarySerializer<EpisodeEntity> serializer,
                             int reindexSize,
                             Object sample,
                             UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            EpisodeEntity.class,
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
