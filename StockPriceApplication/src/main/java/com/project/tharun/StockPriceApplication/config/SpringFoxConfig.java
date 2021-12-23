package com.project.tharun.StockPriceApplication.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket docket()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Stock Market charting API")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }
    private Predicate<String> postPaths() {
        return or(regex("/stockPrices.*"));
    }
    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title("Stock Prices Rest API")
                .description("API reference for Stock Price Service")
                .contact(new Contact("Tharun","https://github.com/BTSKumarReddy/Project","bukkasamudramtharun@gmail.com"))
                .version("1.0")
                .build();

    }
}