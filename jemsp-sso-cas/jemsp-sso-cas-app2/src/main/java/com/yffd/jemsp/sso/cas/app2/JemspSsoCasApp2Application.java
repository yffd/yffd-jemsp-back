package com.yffd.jemsp.sso.cas.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class JemspSsoCasApp2Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JemspSsoCasApp2Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JemspSsoCasApp2Application.class);
    }

}
