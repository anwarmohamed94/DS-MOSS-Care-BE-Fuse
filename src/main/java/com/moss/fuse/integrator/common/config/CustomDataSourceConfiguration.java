package com.moss.fuse.integrator.common.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "customEntityManagerFactory", transactionManagerRef = "customTransactionManager", basePackages = {
		"com.moss.fuse.integrator.custom.repository" })
public class CustomDataSourceConfiguration {

	@Primary
	@Bean(name = "customDataSourceProperties")
	@ConfigurationProperties(prefix = "spring.datasource-custom")
	public DataSourceProperties customDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean(name = "customDataSource")
	@ConfigurationProperties("spring.datasource-custom.configuration")
	public DataSource customDataSource(
			@Qualifier("customDataSourceProperties") DataSourceProperties customDataSourceProperties) {
		return customDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Primary
	@Bean(name = "customEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean customEntityManagerFactory(
			EntityManagerFactoryBuilder customEntityManagerFactoryBuilder,
			@Qualifier("customDataSource") DataSource customDataSource) {

		Map<String, String> customJpaProperties = new HashMap<>();
		customJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		customJpaProperties.put("hibernate.hbm2ddl.auto", "update");

		return customEntityManagerFactoryBuilder.dataSource(customDataSource).packages("com.moss.fuse.integrator.custom.model")
				.persistenceUnit("customDataSource").properties(customJpaProperties).build();
	}

	@Primary
	@Bean(name = "customTransactionManager")
	public PlatformTransactionManager customTransactionManager(
			@Qualifier("customEntityManagerFactory") EntityManagerFactory customEntityManagerFactory) {

		return new JpaTransactionManager(customEntityManagerFactory);
	}
}
