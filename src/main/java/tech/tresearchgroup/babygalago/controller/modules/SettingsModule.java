package tech.tresearchgroup.babygalago.controller.modules;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import com.zaxxer.hikari.HikariDataSource;
import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;
import io.activej.serializer.SerializerBuilder;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.controller.controllers.UserController;
import tech.tresearchgroup.babygalago.controller.controllers.UserSettingsController;
import tech.tresearchgroup.schemas.galago.entities.UserSettingsEntity;

public class SettingsModule extends AbstractModule {
    @Provides
    SettingsController settingsController() {
        return new SettingsController();
    }
}
