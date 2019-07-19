package com.fy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan({"com.fy.staff.mapper"})  //扫描mapper接口
//提醒注册把我注册进去
@EnableDiscoveryClient
public class StaffServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(StaffServerApplication.class, args);
	}

}
