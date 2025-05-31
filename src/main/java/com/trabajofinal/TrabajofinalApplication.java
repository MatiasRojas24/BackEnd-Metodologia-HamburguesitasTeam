package com.trabajofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrabajofinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabajofinalApplication.class, args);
		System.out.println();
		System.out.println("La base de datos esta corriendo");
	}

}
