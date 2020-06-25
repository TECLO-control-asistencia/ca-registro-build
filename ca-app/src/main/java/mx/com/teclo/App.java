package mx.com.teclo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Aplicación de escritorio para leer huellas
 * 
 * @author beatriz.orosio@unitis.com.mx
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = "mx.com.teclo")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("Spring boot application running with starter parent");

	}

}
