package br.com.southrocklab.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Value("${springdoc.version}")
    private String version;
    @Value("${springdoc.title}")
    private String title;
    @Value("${springdoc.terms}")
    private String terms;
    @Value("${springdoc.license}")
    private String license;
    @Value("${springdoc.url}")
    private String url;

    @Bean
    public Docket api() throws Exception {
        return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .select().apis(RequestHandlerSelectors.basePackage("br.com.southrocklab"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact(null, url, null);
        return new ApiInfo(title, null, version, terms, contact, license, url,
            Collections.emptyList());
    }
}
