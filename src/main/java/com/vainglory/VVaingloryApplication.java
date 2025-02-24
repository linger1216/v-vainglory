package com.vainglory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vainglory.mapper")
public class VVaingloryApplication {
	public static void main(String[] args) {
		SpringApplication.run(VVaingloryApplication.class, args);
	}
}
