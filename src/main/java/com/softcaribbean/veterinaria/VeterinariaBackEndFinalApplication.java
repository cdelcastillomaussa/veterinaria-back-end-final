package com.softcaribbean.veterinaria;

import com.softcaribbean.veterinaria.config.FiltrosCors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@SpringBootApplication
public class VeterinariaBackEndFinalApplication {

    public static void main(String[] args) {

        SpringApplication.run(VeterinariaBackEndFinalApplication.class, args);
    }


    // Para permitir la conexion de servidores para todas las peticiones DELETE, OPTIONS, PUT & POST
    @Bean
    public FilterRegistrationBean<FiltrosCors> corsFilterRegistration() {
        FilterRegistrationBean<FiltrosCors> registrationBean = new FilterRegistrationBean<>(new FiltrosCors());
        registrationBean.setName("filtros CORS");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }

}
