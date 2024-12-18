package com.sistema.financeiro;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200") // Permitir requisições do frontend Angular
            .allowedHeaders("*") // Todos os headers permitidos
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true);    
        }

}
