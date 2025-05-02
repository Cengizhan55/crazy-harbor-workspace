package com.crazycoder.crazyharborbff.controller.health;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/health/v1")
public class HealthController {

    private final JdbcTemplate jdbcTemplate;

    private final RedisTemplate redisTemplate;

    public HealthController(JdbcTemplate jdbcTemplate, RedisTemplate redisTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/application")
    public ResponseEntity<String> checkApplicationHealth() {
        return ResponseEntity.ok("Application is up and running..");
    }

    @GetMapping("/database")
    public ResponseEntity<String> checkDatabaseHealth() {

        List<Object> results = jdbcTemplate.query("select * from health_check", new SingleColumnRowMapper<>());
        if (results.size() == 0) {
            return ResponseEntity.ok("Database up and running..");
        }
        return ResponseEntity.ok("Database is not running.");
    }

    @GetMapping("/redis")
    public String checkDatabaseHealth1() {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        String userCount = (String) valueOperations.get("user_count");
        return "usercount is " + userCount;
    }
}
