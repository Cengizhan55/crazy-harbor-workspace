package com.crazycoder.crazyharborbff.controller.parameter.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParameterResponse {
    private Long id;
    private String applicationName;
    private String key;
    private String value;
}
