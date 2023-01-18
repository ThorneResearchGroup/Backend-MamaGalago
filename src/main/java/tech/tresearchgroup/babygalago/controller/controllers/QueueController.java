package tech.tresearchgroup.babygalago.controller.controllers;

import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import io.activej.serializer.BinarySerializer;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.controller.queues.ConverterWorker;
import tech.tresearchgroup.palila.controller.GenericController;
import tech.tresearchgroup.palila.model.enums.PermissionGroupEnum;
import tech.tresearchgroup.schemas.galago.entities.QueueEntity;

import com.zaxxer.hikari.HikariDataSource;
import java.util.LinkedList;
import java.util.List;

public class QueueController extends GenericController {
    private static final JobDetail converterWorker = JobBuilder.newJob(ConverterWorker.class)
        .withIdentity("converter", "queue")
        .build();

    private static Scheduler scheduler;
    private static SettingsController settingsController;
    public final static List<QueueEntity> jobs = new LinkedList<>();

    public QueueController(HikariDataSource hikariDataSource,
                           Gson gson,
                           Client client,
                           BinarySerializer<QueueEntity> serializer,
                           int reindexSize,
                           SettingsController settingsController,
                           UserController userController) throws Exception {
        super(
            hikariDataSource,
            gson,
            client,
            QueueEntity.class,
            serializer,
            reindexSize,
            null,
            null,
            PermissionGroupEnum.USER,
            PermissionGroupEnum.USER,
            PermissionGroupEnum.USER,
            PermissionGroupEnum.USER,
            PermissionGroupEnum.USER,
            userController
        );
        scheduler = StdSchedulerFactory.getDefaultScheduler();
        Trigger converterTrigger = TriggerBuilder.newTrigger()
            .withIdentity("converterTrigger", "queue")
            .startNow()
            .withSchedule(SimpleScheduleBuilder.simpleSchedule())
            .build();
        scheduler.scheduleJob(converterWorker, converterTrigger);
        scheduler.start();
        QueueController.settingsController = settingsController;
    }

    public boolean stopConverterQueue() {
        try {
            scheduler.pauseJob(converterWorker.getKey());
            return true;
        } catch (SchedulerException e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean startConverterQueue() {
        try {
            scheduler.resumeJob(converterWorker.getKey());
            return true;
        } catch (SchedulerException e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean isConverterQueueRunning() {
        try {
            return !isJobPaused(converterWorker);
        } catch (SchedulerException e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean isJobPaused(JobDetail jobDetail) throws SchedulerException {
        List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobDetail.getKey());
        for (Trigger trigger : triggers) {
            Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
            if (Trigger.TriggerState.PAUSED.equals(triggerState)) {
                return true;
            }
        }
        return false;
    }

    public static long getQueueSize() {
        return jobs.size();
    }
}
