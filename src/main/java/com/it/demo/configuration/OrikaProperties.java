package com.it.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "orika")
public class OrikaProperties {
    private Boolean useDefaultMapper;
    private Boolean mapNull;

    public Boolean getUseDefaultMapper() {
        return useDefaultMapper;
    }

    public void setUseDefaultMapper(Boolean useDefaultMapper) {
        this.useDefaultMapper = useDefaultMapper;
    }

    public Boolean getMapNull() {
        return mapNull;
    }

    public void setMapNull(Boolean mapNull) {
        this.mapNull = mapNull;
    }
}
