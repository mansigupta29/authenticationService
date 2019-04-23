package com.mansi.serviceauth;

import com.mansi.serviceauth.security.JwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
public class ServiceAuthApplication {


	public static void main(String[] args) {
		SpringApplication.run(ServiceAuthApplication.class, args);
	}

}
