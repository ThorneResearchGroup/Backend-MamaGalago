package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.CompanyEntity;

import com.zaxxer.hikari.HikariDataSource;

public class CompanyController extends GenericController {
    public CompanyController(HikariDataSource hikariDataSource,
                             Gson gson,
                             Client client,
                             BinarySerializer<CompanyEntity> serializer,
                             int reindexSize,
                             Object sample,
                             UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            CompanyEntity.class,
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
