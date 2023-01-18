package tech.tresearchgroup.babygalago.controller.queues;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import tech.tresearchgroup.babygalago.controller.controllers.QueueController;
import tech.tresearchgroup.babygalago.model.SettingsEntity;

public class ConverterWorker implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        for (; ; ) {
            try {
                //Todo accept incoming requests
                for (int i = 0; i < QueueController.jobs.size(); i++) {
                    System.out.println(QueueController.jobs.get(i).toString());
                    QueueController.jobs.remove(i);
                    i--;
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                if (SettingsEntity.debug) {
                    e.printStackTrace();
                }
            }
        }
    }
}
