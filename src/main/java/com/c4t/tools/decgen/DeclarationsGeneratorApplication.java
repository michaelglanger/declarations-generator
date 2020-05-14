package com.c4t.tools.decgen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeclarationsGeneratorApplication {

    private static Logger LOG = LoggerFactory.getLogger(DeclarationsGeneratorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DeclarationsGeneratorApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(Builder builder) {
        return (args) -> {
            builder.build();
        };
    }

//    @Override
//    public void run(String... args) throws Exception {
//
////        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        Builder builder = new Builder();//ctx.getBean(Builder.class);
//        builder.build();
//    }



}
