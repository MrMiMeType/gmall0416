package com.atguigu.gmall0416.usermanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.gmall0416.usermanage.mapper")
public class Gmall0416Application {

	public static void main(String[] args) {
		SpringApplication.run(Gmall0416Application.class, args);
	}
}
