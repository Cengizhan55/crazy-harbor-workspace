package com.crazycoder.crazyharborbff.config.application;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "application-properties")
public class ApplicationProperties {

    private String name;
}
