package com.asociacion.monterde.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")                        // Grupo de la API
                .packagesToScan("com.asociacion.monterde")  // Paquete donde están tus controladores
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de la Asociación Cultural Monterde")
                        .version("1.0")
                        .description("Documentación de la API para la gestión de miembros, eventos y recursos de la Asociación Cultural Monterde"));
    }
}
