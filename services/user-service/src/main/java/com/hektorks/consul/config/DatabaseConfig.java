package com.hektorks.consul.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "database")
public class DatabaseConfig {
  private String driver;
  private String url;
  private String username;
  private char[] password;
  private Integer maximumPoolSize;
}
