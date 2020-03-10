package br.com.segnum.api.config;

import static springfox.documentation.builders.PathSelectors.regex;
import java.util.Collections;
import java.util.Set;

import br.com.segnum.api.domain.*;
import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("br.com.segnum.api.resources"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo())
                .ignoredParameterTypes(ignoreClasses());
    }
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Segum API")
                .description("Segum REST API Documentation")
                .contact(new Contact("Equipe Segnum", "www.segnum.com.br", "contato@segnum.com.br"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

    private Class[] ignoreClasses() {
        Class[] ignored = {
                Event.class,
                User.class,
                EventType.class,
                Location.class,
                Vote.class,
                Commentary.class
        };
        return ignored;
    }
}
