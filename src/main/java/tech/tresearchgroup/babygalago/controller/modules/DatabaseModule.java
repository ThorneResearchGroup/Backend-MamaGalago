package tech.tresearchgroup.babygalago.controller.modules;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;
import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.model.SettingsEntity;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseModule extends AbstractModule {
    @Provides
    HikariDataSource hikariDataSource(SettingsController settingsController) throws ManagedProcessException, SQLException {
        switch(SettingsEntity.databaseType) {
            case STANDALONE -> {
                String username = System.getenv("DB_USER");
                String password = System.getenv("DB_PASS");
                if(username == null) {
                    System.out.println("Cannot connect to DB because your DB_USER environment variable is null");
                    System.exit(0);
                }else if(password == null) {
                    System.out.println("Cannot connect to DB because your DB_PASS environment variable is null");
                    System.exit(0);
                }
                return getConfig(settingsController, username, password, settingsController.getDatabaseName());
            }
            case EMBEDDED -> {
                return getEmbeddedConfig(settingsController);
            }
            case AUTO -> {
                try {
                    String username = System.getenv("DB_USER");
                    String password = System.getenv("DB_PASS");
                    return getConfig(settingsController, username, password, settingsController.getDatabaseName());
                } catch (HikariPool.PoolInitializationException e) {
                    try {
                        return getEmbeddedConfig(settingsController);
                    } catch (Exception ex) {
                        System.err.println("Failed to start embedded server. Please setup a standalone server.");
                        System.exit(0);
                    }
                }
            }
        }
        return null;
    }

    HikariDataSource getEmbeddedConfig(SettingsController settingsController) throws ManagedProcessException, SQLException {
        File databaseFolder = new File("./db");
        if(!databaseFolder.exists()) {
            if(!databaseFolder.mkdir()) {
                System.out.println("Failed to create the database folder.");
                return null;
            }
        }
        DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
        configBuilder.setPort(3306);
        configBuilder.setDataDir("./db");
        DB db = DB.newEmbeddedDB(configBuilder.build());
        db.start();
        HikariDataSource hikariDataSource = getConfig(settingsController, "root", "", "");
        Connection connection = hikariDataSource.getConnection();
        if(!databaseExists(connection, settingsController.getDatabaseName())) {
            System.out.println("Creating database table...");
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE DATABASE " + settingsController.getDatabaseName());
            preparedStatement.executeUpdate();
            connection.commit();
        } else {
            System.out.println("Database exists...");
        }
        connection.close();
        return getConfig(settingsController, "root", "", settingsController.getDatabaseName());
    }

    HikariDataSource getConfig(SettingsController settingsController, String username, String password, String database) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mariadb://localhost/" + database);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(settingsController.getMaxDatabaseConnections());
        config.setMinimumIdle(settingsController.getMinDatabaseConnections());
        return new HikariDataSource(config);
    }

    boolean databaseExists(Connection connection, String table) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(SCHEMA_NAME) AS COUNT FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + table + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            Long number = resultSet.getLong("COUNT");
            return number > 0;
        } else {
            return false;
        }
    }
}
