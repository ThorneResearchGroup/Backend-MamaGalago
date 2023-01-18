package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.GameEngineEntity;

import com.zaxxer.hikari.HikariDataSource;

public class GameEngineController extends GenericController {
    public GameEngineController(HikariDataSource hikariDataSource,
                                Gson gson,
                                Client client,
                                BinarySerializer<GameEngineEntity> serializer,
                                int reindexSize,
                                Object sample,
                                UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            GameEngineEntity.class,
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
