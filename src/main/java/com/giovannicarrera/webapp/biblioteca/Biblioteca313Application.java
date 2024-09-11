package com.giovannicarrera.webapp.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.giovannicarrera.webapp.biblioteca.system.Main;

import javafx.application.Application;

@SpringBootApplication
public class Biblioteca313Application {

	public static void main(String[] args) {
		//levanta JAVAFX
		Application.launch(Main.class);
		//levanta SpringBoot
		SpringApplication.run(Biblioteca313Application.class, args);
	}

}
