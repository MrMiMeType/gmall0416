package com.atguigu.gmall0416.usermanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.gmall0416.usermanage.mapper")
public class Gamll0416Application {

	public static void main(String[] args) {
		SpringApplication.run(Gamll0416Application.class, args);
	}
}
