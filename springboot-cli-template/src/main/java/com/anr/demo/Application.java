package com.anr.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = { EmbeddedWebServerFactoryCustomizerAutoConfiguration.class,
        EmbeddedMongoAutoConfiguration.class, MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
@SpringBootApplication
public class Application implements CommandLineRunner {

    static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        checkPGConn();
        // printBeansInAppContext(context);
    }

    private void checkPGConn() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sonarqube", "sonarqube", "admin");
            logger.debug("Opened database successfully");
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug(e.getClass().getName() + ": " + e.getMessage());
        }
        logger.debug("end of method");
    }

    private void printBeansInAppContext(ApplicationContext ctx) {
        if (logger.isDebugEnabled()) {
            logger.debug("###################################");
            logger.debug("inspect beans initialized by springboot");
            logger.debug("###################################");
        }
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            logger.info(beanName);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("###################################");
            logger.debug("end of method");
            logger.debug("###################################");
        }
    }

}
