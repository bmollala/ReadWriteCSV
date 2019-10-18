package co.za.assessment.ReadWriteCSV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages="co.za.assessment.ReadWriteCSV")
public class ReadWriteCsvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadWriteCsvApplication.class, args);
	}

}
