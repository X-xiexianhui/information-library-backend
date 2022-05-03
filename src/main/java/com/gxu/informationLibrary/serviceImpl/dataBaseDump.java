package com.gxu.informationLibrary.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class dataBaseDump {
    @Scheduled(cron = "0 0 12 ? * 7")
    public void dump() throws Exception {
        log.info("备份数据库");
        dataBaseDumpTask();
    }

    //mysqldump db.. > ./dump/back.sql
    //备份
    public static void dataBaseDumpTask() throws Exception {
        String backTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        File file = new File("./dump");
        if (!file.exists()) {
            file.mkdir();
        }
        File datafile = new File(file + File.separator+"backup_"+backTime+ ".sql");
        if (datafile.exists()) {
            System.out.println("backup_"+backTime+ ".sql" + "文件名已存在，请更换");
            return;
        }
        //拼接cmd命令
        Process exec = Runtime.getRuntime().exec("/bin/sh -c mysqldump --databases" + "db_name"+">"+datafile);
        if (exec.waitFor() == 0) {
            System.out.println("数据库备份成功,备份路径为：" + datafile);
        }
    }
}
