package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.ImageEntity;

import com.zaxxer.hikari.HikariDataSource;

public class ImageController extends GenericController {
    public ImageController(HikariDataSource hikariDataSource,
                           Gson gson,
                           Client client,
                           BinarySerializer<ImageEntity> serializer,
                           int reindexSize,
                           Object sample,
                           UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            ImageEntity.class,
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
