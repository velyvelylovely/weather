package com.zerobase.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	Docket api() {
		 return new Docket(DocumentationType.SWAGGER_2)
				 .useDefaultResponseMessages(true)
				 .select()
				 .apis(RequestHandlerSelectors.basePackage("com.zerobase.weather"))
				 .paths(PathSelectors.any())
				 .build().apiInfo(apiInfo());
	}
	
	 private ApiInfo apiInfo() {
		 String description = "날씨 일기를 CRUD 할 수 있는 프로젝트 입니다.";
		 return new ApiInfoBuilder()
		 .title("날씨 일기 프로젝트 :)")
		 .description(description)
		 .version("1.0")
		 .build();
	}
}
