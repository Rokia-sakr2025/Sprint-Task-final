package com.SprintDemo.utilites;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {
    public FileUtils()
    {
        super();
    }

    public  static  void deleteFiles(File direpath) {
        if (direpath == null || !direpath.exists()) {
            LogsUtil.warn("Directory not found" + direpath);
        }
        File[] fileslist = direpath.listFiles();
        if (fileslist == null) {
            LogsUtil.warn("failed to list files" + direpath);
            return;
        }


        for (File file : fileslist) {
            if (file.isDirectory()){
                deleteFiles(file);
                LogsUtil.info("previous files are removed ");
            }
            else {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    LogsUtil.error("Failed to delete file "+file);
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
