package com.david.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("demo")
public class SfgConstructorConfig {

    private final String username;
    private final String password;
    private final String dbUrl;

    public SfgConstructorConfig(String username, String password, String dbUrl) {
        this.username = username;
        this.password = password;
        this.dbUrl = dbUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDbUrl() {
        return dbUrl;
    }
}
