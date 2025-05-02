package com.crazycoder.crazyharborbff.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * these runners starts after the spring boot application starts. Not after the finish but after the startup.
 * You can take args or make bean declaration.
 */
@Component
@Slf4j
public class ApplicationStartupRunner implements CommandLineRunner, ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Application Arguments : down below ");
        args.getOptionNames().forEach(System.out::println);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("String args -->  " + args.toString() );

    }
}
