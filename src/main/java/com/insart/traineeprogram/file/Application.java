package com.insart.traineeprogram.file;

import java.util.ResourceBundle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
public class Application {
	
	public static String ROOT = ResourceBundle.getBundle("dataBase").getString("ROOT_STORAGE_PATH");
//
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//
//    @Bean
//    CommandLineRunner init() {
//        return (String[] args) -> {
//            new File(ROOT).mkdir();
//        };
//    }

}
