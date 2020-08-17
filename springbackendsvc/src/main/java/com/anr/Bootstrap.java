package com.anr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
// @Slf4j
@EnableAspectJAutoProxy
@EnableSwagger2
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class Bootstrap extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
        // SpringApplication app = new SpringApplication(DemoApplication.class);
        // app.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Bootstrap.class);
    }

}
