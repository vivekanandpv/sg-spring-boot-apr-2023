package com.vivekanandpv.springbootstarterproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    private String key;
    private int retryCount;

    public AppConfig(@Value("${app.key}") String key, @Value("${foo.retry.count}") int retryCount) {
        this.key = key;
        this.retryCount = retryCount;
    }

    public String getKey() {
        return key;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
