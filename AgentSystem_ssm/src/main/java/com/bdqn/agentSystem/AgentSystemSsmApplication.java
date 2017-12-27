package com.bdqn.agentSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bdqn.agentSystem.interceptors.SystemInit;

@SpringBootApplication
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class AgentSystemSsmApplication {

	@Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AgentSystemSsmApplication.class);  
		app.addListeners(new SystemInit());
		app.run(args);
	}
}
