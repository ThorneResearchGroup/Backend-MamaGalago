package tech.tresearchgroup.colobus.controller.modules;

import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;
import tech.tresearchgroup.babygalago.controller.controllers.UserController;
import tech.tresearchgroup.colobus.controller.IndexController;
import tech.tresearchgroup.colobus.view.IndexPage;


public class ForumControllersModule extends AbstractModule {
    @Provides
    IndexController indexController(UserController userController,
                                    IndexPage indexPage) {
        return new IndexController(
            userController,
            indexPage
        );
    }
}
