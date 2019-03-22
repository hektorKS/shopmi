package com.hektorks.database;

import com.hektorks.consul.config.DatabaseConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
@EnableTransactionManagement
@MapperScan("com.hektorks.user.common.repository.mappers")
class DatabaseConfigurationInjector {
  private final DatabaseConfig databaseConfig;

  @Bean
  DataSource getDataSource() {
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setJdbcUrl(databaseConfig.getUrl());
    hikariConfig.setUsername((databaseConfig.getUsername()));
    hikariConfig.setPassword(new String(databaseConfig.getPassword()));
    hikariConfig.setDriverClassName(databaseConfig.getDriver());
    hikariConfig.setMaximumPoolSize(databaseConfig.getMaximumPoolSize());
    return new HikariDataSource(hikariConfig);
  }

  @Bean
  SqlSessionFactory getSqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(getDataSource());
    sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  SqlSessionTemplate getSqlSessionTemplate() throws Exception {
    return new SqlSessionTemplate(getSqlSessionFactory());
  }

  @Bean
  DataSourceTransactionManager getDataSourceTransactionManager() {
    return new DataSourceTransactionManager(getDataSource());
  }

}
