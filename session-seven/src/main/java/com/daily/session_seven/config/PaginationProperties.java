package com.daily.session_seven.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@ConfigurationProperties(prefix = "app.pagination")
@ConstructorBinding
@Validated
public class PaginationProperties {

    @Min(1)
    private final int defaultSize;

    @Min(1)
    private final int maxSize;

    public PaginationProperties(int defaultSize, int maxSize) {
        this.defaultSize = defaultSize;
        this.maxSize = maxSize;
    }

    public int getDefaultSize() {
        return defaultSize;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
