package com.blcl.configurations;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.blcl.utils.Constants;

@Configuration
@EnableTransactionManagement
public class Config {

	private Logger log = Logger.getLogger(Config.class);
	
	@Autowired
	private Environment env;
	
	private Constants constants;

	private void init() {
		if (constants == null) {
			constants = Constants.getInstance();

			constants.init(
					env.getProperty("server.port"), 
					env.getProperty("driverClassName"), 
					env.getProperty("url"),
					env.getProperty("username"), 
					env.getProperty("password"));
		}
	}
	/*
	@Bean
	public Integer start(){
		init();
		
		return 1;
	}
	*/
	@Bean
	public BasicDataSource basicDataSource() throws GeneralSecurityException, IOException {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(env.getProperty("driverClassName"));
		basicDataSource.setUrl(env.getProperty("url"));
		basicDataSource.setUsername(env.getProperty("username"));
		basicDataSource.setPassword(env.getProperty("password"));
		init();
		log.info("server.port ---> "+Constants.getInstance().getServerPort());
		log.info("driverClassName ---> "+Constants.getInstance().getDriverClassName());
		log.info("url -----> "+Constants.getInstance().getUrl());
		log.info("username -------> "+Constants.getInstance().getUserName());
		log.info("password -------> "+Constants.getInstance().getPassword());
		return basicDataSource;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws GeneralSecurityException, IOException {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setShowSql(false);
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(basicDataSource());
		entityManagerFactoryBean.setPackagesToScan("com.blcl.domains");
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.afterPropertiesSet();
		return entityManagerFactoryBean;
	}
}
