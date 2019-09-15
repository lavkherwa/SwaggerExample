package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public class SwaggerConfig {

	/*- Dummy configuration class for enabling swagger 
	 * 
	 *  With this now we will have a additional end-point enabled
	 *  for our services at the root which will provide the documentation
	 *  
	 *  /v2/api-docs        (for API documentation in JSON)
	 *  /swagger-ui.htm     (for API documentation in UI)
	 * 
	 */

	/*- Control the packages/API's that you want swagger to consider
	 *  for generating the documentation
	 */

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.select() // Start selecting the API's
				.paths(PathSelectors.ant("/api/**")) // Select the paths to be considered
				.apis(RequestHandlerSelectors.basePackage("com.example")) // Packages to consider
				.build().apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("My users service")//
				.description("This is My users service swagger impl example")//
				.version("1.0.0")//
				.termsOfServiceUrl("https://any-dummy-url.com")//
				.contact(new Contact("Lav Kherwa", "https://github.com/lavkherwa", "kherwa.lav@gmail.com"))//
				.build();

	}

}
