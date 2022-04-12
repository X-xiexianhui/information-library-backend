package com.gxu.informationLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class InformationLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationLibraryApplication.class, args);
	}

}
