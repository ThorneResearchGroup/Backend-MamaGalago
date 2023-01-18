package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.GamePlatformReleaseEntity;

import com.zaxxer.hikari.HikariDataSource;

public class GamePlatformReleaseController extends GenericController {
    public GamePlatformReleaseController(HikariDataSource hikariDataSource,
                                         Gson gson,
                                         Client client,
                                         BinarySerializer<GamePlatformReleaseEntity> serializer,
                                         int reindexSize,
                                         Object sample,
                                         UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            GamePlatformReleaseEntity.class,
            serializer,
            reindexSize,
            null,
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
