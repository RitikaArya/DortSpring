package com.murphy.appdownload.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.murphy.appdownload.util.DowntimeServicesUtil;
/**
 * @author Amit dey
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.murphy.appdownload.config")
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

	@Autowired
	private Environment environment;
	
	@Autowired
	@Qualifier("sessionFactoryProcount")
	private SessionFactory sessionFactoryProcount;

	@Bean(name = "sessionFactoryProcount")
	public LocalSessionFactoryBean sessionFactoryProcount() {
		try {
			DowntimeServicesUtil.setupSOCKS();
		} catch (Exception e) {
			System.err.println("Exception while setting up Socks : "+e.getMessage());
		}
		LocalSessionFactoryBean sessionFactoryProcount = new LocalSessionFactoryBean();
		sessionFactoryProcount.setDataSource(dataSource());
		sessionFactoryProcount.setPackagesToScan(new String[] { "com.murphy" });
		sessionFactoryProcount.setHibernateProperties(hibernateProperties());
		return sessionFactoryProcount;
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
//		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.globally_quoted_identifiers","true");
		return properties;        
	}

	@Bean(name = "sessionFactoryTransactionManager")
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(this.sessionFactoryProcount);
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}


