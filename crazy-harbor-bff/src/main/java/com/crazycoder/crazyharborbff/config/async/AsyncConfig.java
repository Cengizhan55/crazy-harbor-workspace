package com.crazycoder.crazyharborbff.config.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
@EnableConfigurationProperties(AsyncExecutorProperties.class)
@Slf4j
public class AsyncConfig implements AsyncConfigurer { // AsyncConfigurer is not necessary , but if we want to make custom settings we need it.

    private final AsyncExecutorProperties executorProperties;

    public AsyncConfig(AsyncExecutorProperties asyncExecutorProperties) {
        this.executorProperties = asyncExecutorProperties;
    }

    @Bean(name = "CrazyHarborThreadPoolTaskExecutor")
    public Executor threadPoolExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(executorProperties.getCorePoolSize());
        executor.setMaxPoolSize(executorProperties.getMaxPoolSize());
        executor.setQueueCapacity(executorProperties.getQueueCapacity());
        executor.setThreadNamePrefix("Crazy-Harbor-Custom-Thread-");
        executor.setRejectedExecutionHandler((r, executor1) -> log.error("Task rejected beacuse of max queue size"));
        executor.initialize();
        return executor;
    }
}