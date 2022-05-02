package com.gxu.informationLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
public class InformationLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationLibraryApplication.class, args);
	}

}
