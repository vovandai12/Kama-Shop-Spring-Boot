package com.example.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSourceBuilder.url(
				"jdbc:sqlserver://localhost;databaseName=KamarShopSpringBoot;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2");
		dataSourceBuilder.username("*************");
		dataSourceBuilder.password("*************");
		return dataSourceBuilder.build();
	}
}