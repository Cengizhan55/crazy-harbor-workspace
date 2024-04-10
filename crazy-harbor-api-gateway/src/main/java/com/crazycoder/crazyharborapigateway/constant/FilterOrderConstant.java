package com.crazycoder.crazyharborapigateway.constant;


import org.springframework.core.Ordered;

public class FilterOrderConstant {

    public FilterOrderConstant() {
        throw new IllegalStateException("This is a constant class");
    }

    public static int API_VERSION_CHECK = Ordered.HIGHEST_PRECEDENCE + 1;
}
