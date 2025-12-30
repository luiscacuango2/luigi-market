package com.luiscacuango.market.web.controller.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("market-api")
                .packagesToScan("com.luiscacuango.market.web.controller")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Luigi Market API 🛒")
                        .version("1.0.0")
                        .description("API para la gestión integral de un supermercado, incluyendo productos, categorías y procesamiento de compras.")
                        .contact(new Contact()
                                .name("Luis Cacuango")
                                .email("luiscacuango2084@gmail.com")
                                .url("https://github.com/luiscacuango2"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));

    }

    // Metodo auxiliar para Spring Security con JWT
    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
