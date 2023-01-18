package tech.tresearchgroup.babygalago.controller.tasks;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import tech.tresearchgroup.babygalago.model.SettingsEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class TvShowLibraryScanTask implements Job {

    public static List<String> processTvShow(Path libraryPath) throws IOException {
        List<Path> files = Files.list(libraryPath).toList();
        List<String> submissions = new LinkedList<>();
        for (Path filePath : files) {
            System.out.println(filePath.toAbsolutePath());
        }
        return submissions;
    }

    @Override
    public void execute(JobExecutionContext context) {
        try {
            System.out.println("Scanning: " + SettingsEntity.tvShowLibraryPath);
            processTvShow(Path.of(SettingsEntity.tvShowLibraryPath));
        } catch (IOException e) {
            if (SettingsEntity.debug) {
                e.printStackTrace();
            }
        }
    }
}
