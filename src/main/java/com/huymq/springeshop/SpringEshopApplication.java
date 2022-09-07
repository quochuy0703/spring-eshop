package com.huymq.springeshop;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.huymq.springeshop.utils.FilesStorageService;

@SpringBootApplication
public class SpringEshopApplication implements CommandLineRunner {
	
	@Resource
    FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEshopApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {

	  storageService.init();
	}

}
