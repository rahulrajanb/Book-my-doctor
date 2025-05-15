package com.TekPyramid.BookMyDoctor.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI mySwaggerConfig(){
        return  new OpenAPI().info(new Info().title("BOOK MY DOCTOR APPLICATION").version("V1").description("This is an Application for booking Doctor"));
    }
}
