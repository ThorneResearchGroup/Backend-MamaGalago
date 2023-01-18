package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.BookEntity;

import com.zaxxer.hikari.HikariDataSource;

public class BookController extends GenericController {
    public BookController(HikariDataSource hikariDataSource,
                          Gson gson,
                          Client client,
                          BinarySerializer<BookEntity> serializer,
                          int reindexSize,
                          Object sample,
                          UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            BookEntity.class,
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
