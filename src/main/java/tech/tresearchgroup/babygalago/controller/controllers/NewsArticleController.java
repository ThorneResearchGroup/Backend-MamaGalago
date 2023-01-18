package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.NewsArticleEntity;

import com.zaxxer.hikari.HikariDataSource;

public class NewsArticleController extends GenericController {
    public NewsArticleController(HikariDataSource hikariDataSource,
                                 Gson gson,
                                 Client client,
                                 BinarySerializer<NewsArticleEntity> serializer,
                                 int reindexSize,
                                 Object sample,
                                 UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            NewsArticleEntity.class,
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
