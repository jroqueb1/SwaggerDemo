package com.appsdeveloperblog.app.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class ApplicationSwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Version 1.0")
				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.appsdeveloperblog.app.ws.controller"))
//				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/v1/**"))
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Mobile App Service API")
				.version("1.0")
				.description("Web Service API para comunicacion con Mobile APP")
				.contact(new Contact("Codmind", "https://codmind.com", "apis@codmind.com"))
				.license("Licence MIT")
				.build();
		
//		return new ApiInfo(
//				"Order Service API",
//				"Order Service API Description",
//				"1.0",
//				"http://codmind.com/terms",
//				new Contact("Codmind", "https://codmind.com", "apis@codmind.com"),
//				"LICENSE",
//				"LICENSE URL",
//				new ArrayList<>()
//				);
	}
	
}
