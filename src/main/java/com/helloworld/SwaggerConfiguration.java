package com.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration  {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.helloworld.controller"))
				.build().apiInfo(metaData());

	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Spring Boot  helloworld REST API", "Spring Boot helloworld for App Store", "1.0",
				"Apps service",
				new Contact("Hemant Shah", "gshah.hemantkumar@gmail.com", "gshah.hemant@gmail.com"),
				"helloworld", "helloworld");
		return apiInfo;
	}

}
