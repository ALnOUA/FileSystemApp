package com.ua.springfilesystemapp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "init.data")
@Getter
@Setter
public class InitConfig {
    private String oldWord;
    private String newWord;
    private String startFilePath;
}
