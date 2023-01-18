package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.FileEntity;

import com.zaxxer.hikari.HikariDataSource;

public class FileController extends GenericController {
    public FileController(HikariDataSource hikariDataSource,
                          Gson gson,
                          Client client,
                          BinarySerializer<FileEntity> serializer,
                          int reindexSize,
                          Object sample,
                          UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            FileEntity.class,
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
