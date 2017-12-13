package com.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  //开启事务管理
public class SpringBoot01SsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01SsmApplication.class, args);
	}
}
