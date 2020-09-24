package com.lsq.demo;

import com.lsq.demo.mapper.CityMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lsq.demo.mapper")
public class BootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootdemoApplication.class, args);
	}

}
