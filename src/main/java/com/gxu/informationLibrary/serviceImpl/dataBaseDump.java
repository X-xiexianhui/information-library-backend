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
        String backName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        dataBaseDump("localhost", "3306", "root", "123456", "excel", backName);
    }

    //mysqldump -hlocalhost -P3306 -uroot -p123456 db > E:/back.sql
    //备份
    public static void dataBaseDump(String host, String port, String username, String password, String databasename, String sqlname) throws Exception {
        File file = new File("./dump");
        if (!file.exists()) {
            file.mkdir();
        }
        File datafile = new File(file + File.separator + sqlname + ".sql");
        if (datafile.exists()) {
            System.out.println(sqlname + "文件名已存在，请更换");
            return;
        }
        //拼接cmd命令
        Process exec = Runtime.getRuntime().exec("/bin/sh -c mysqldump -h" + host + " -P" + port + " -u " + username + " -p" + password + " " + databasename + " > " + datafile);
        if (exec.waitFor() == 0) {
            System.out.println("数据库备份成功,备份路径为：" + datafile);
        }
    }
}
