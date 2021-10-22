package com.savio.project.coronavirus.config;

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

    public static final String ENDERECO = "com.savio.project.coronavirus";
    public static final String TITULO = "Coronavirus Brasil";
    public static final String DESCRICAO = "Projeto da disciplina Projeto de Software, da graduação em " +
            "Ciências da Computação na Universidade Federal de Campina Grande";
    public static final String VERSION = "1.0.0";
    public static final String NAME = "Sávio Medeiros";
    public static final String URL = "github.com/medeirosavio";
    public static final String EMAIL = "savio.medeiros@ccc.ufcg.edu.br";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(ENDERECO))
                .paths(PathSelectors.any())
                .build().apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(TITULO)
                .description(DESCRICAO)
                .version(VERSION)
                .contact(new Contact(NAME, URL, EMAIL))
                .build();
    }

}
