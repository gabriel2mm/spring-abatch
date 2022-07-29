package br.com.spring.batch.example.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfiguration {

    private static final String PREFIX_SPRING_BATCH_DATASOURCE = "spring.datasource";

    @Bean
    @Primary
    @ConfigurationProperties(prefix = PREFIX_SPRING_BATCH_DATASOURCE)
    public DataSource springDataSource(){
        return DataSourceBuilder.create().build();
    }
}
