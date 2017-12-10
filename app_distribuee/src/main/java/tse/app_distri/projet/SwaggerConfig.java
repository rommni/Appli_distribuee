package tse.app_distri.projet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
 
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket AppDistribueeApplication() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()                                  
                .apis(RequestHandlerSelectors.any())              
                .paths(regex("/jobs.*"))                         
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Humanressources Info6 API",
                "Spring Boot REST API for Human ressources",
                "1.0",
                "Terms of service",
                new Contact("JULIAN Romain & LAURIER Alexis", "https://www.telecom-st-etienne.fr", "romain.julian@telecom-st-etienne.fr"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }
}