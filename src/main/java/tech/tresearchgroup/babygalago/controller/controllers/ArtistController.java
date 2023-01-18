package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import com.zaxxer.hikari.HikariDataSource;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.ArtistEntity;

public class ArtistController extends GenericController {
    public ArtistController(HikariDataSource hikariDataSource,
                            Gson gson,
                            Client client,
                            BinarySerializer<ArtistEntity> serializer,
                            int reindexSize,
                            Object sample,
                            UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            ArtistEntity.class,
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
