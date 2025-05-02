package com.crazycoder.crazyharborbff.domain.service.async;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncTestService {

    @Async("CrazyHarborThreadPoolTaskExecutor")
    public void makeAsyncRequest() throws InterruptedException {

        log.info("ASYNC STARTED SYSTEM TIME : " + System.currentTimeMillis());
        Thread.sleep(5000L);
        log.info("ASYNC ENDED SYSTEM TIME : " + System.currentTimeMillis());
    }
}
