package com.swg.common.config.database;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.swg.common.repository")
@ComponentScan("com.swg.common.service")
@EnableTransactionManagement
@EnableJpaAuditing
public class DataSourceConfiguration {

    @Value("${database.sgw.userName}")
    private String userName;
    @Value("${database.sgw.password}")
    private String password;
    @Value("${database.sgw.driverClass}")
    private String driverClass;
    @Value("${database.sgw.maximumPoolSize}")
    private Integer maximumPoolSize;
    @Value("${database.sgw.minimumIdle}")
    private Integer minimumIdle;
    @Value("${database.sgw.databasePlatform}")
    private String databasePlatform;
    @Value("${database.sgw.jdbcUrl}")
    private String jdbcUrl;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClass);
        dataSource.setMinimumIdle(maximumPoolSize);
        dataSource.setMaximumPoolSize(minimumIdle);
        dataSource.setJdbcUrl(jdbcUrl);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(jpaVendorAdapter());
        factory.setPackagesToScan("com.swg.common.domain");
        factory.setDataSource(dataSource());
        return factory;
    }

    private HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabasePlatform(databasePlatform);
        return vendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}