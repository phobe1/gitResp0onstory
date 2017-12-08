package com.open.ssm.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务管理
@ComponentScan("com.open.ssm")
@MapperScan("com.open.ssm.mapper")
public class SpringBoot01Ssm1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01Ssm1Application.class, args);
	}
}
