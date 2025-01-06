package com.crazycoder.crazyharborbff.controller.async;


import com.crazycoder.crazyharborbff.domain.service.async.AsyncTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("async/test")
public class AsyncTestController {

    private final AsyncTestService asyncTestService;

    public AsyncTestController(AsyncTestService asyncTestService) {
        this.asyncTestService = asyncTestService;

    }


    @GetMapping
    public ResponseEntity<String> testAsyncTask() throws InterruptedException {

        asyncTestService.makeAsyncRequest();

        return ResponseEntity.ok("ok");
    }
}
