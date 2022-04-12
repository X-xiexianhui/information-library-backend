package com.gxu.informationLibrary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.gxu.informationLibrary.dao")
public class InformationLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationLibraryApplication.class, args);
	}

}
