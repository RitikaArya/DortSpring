//package com.murphy.appdownload.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate4.HibernateTransactionManager;
//import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.murphy.appdownload.util.DowntimeServicesUtil;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan(basePackages = "com.murphy.appdownload.config")
//@PropertySource(value = { "classpath:application.properties" })
//public class HibernateConfigurationHana {
//	
//	@Autowired
//	private Environment environment;
//
//	@Autowired
//	@Qualifier("sessionFactoryHana")
//	private SessionFactory sessionFactoryHana;
//	
//	@Bean(name = "sessionFactoryHana")
//	public LocalSessionFactoryBean sessionFactoryHana() {
//		try {
//			DowntimeServicesUtil.unSetupSOCKS();
//		} catch (Exception e) {
//			System.err.println("[Murphy][BaseDao][getSession][Socks Exception] "+e.getMessage());
//		}
//		LocalSessionFactoryBean sessionFactoryHana = new LocalSessionFactoryBean();
//		sessionFactoryHana.setDataSource(dataSourceHana());
//		sessionFactoryHana.setPackagesToScan(new String[] { "com.murphy" });
//		sessionFactoryHana.setHibernateProperties(hibernatePropertiesHana());
//		return sessionFactoryHana;
//	}
//
//	@Bean(name = "dataSourceHana")
//	public DataSource dataSourceHana() {
//		DriverManagerDataSource dataSourceHana = new DriverManagerDataSource();
//		dataSourceHana.setDriverClassName(environment.getRequiredProperty("jdbc.sap.driverClassName"));
//		dataSourceHana.setUrl(environment.getRequiredProperty("jdbc.sap.url"));
//		dataSourceHana.setUsername(environment.getRequiredProperty("jdbc.sap.username"));
//		dataSourceHana.setPassword(environment.getRequiredProperty("jdbc.sap.password"));
//		return dataSourceHana;
//	}
//
//	private Properties hibernatePropertiesHana() {
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.sap.dialect"));
//		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
//		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
////		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//		properties.put("hibernate.globally_quoted_identifiers","true");
//		return properties;        
//	}
//
//	@Bean(name = "sessionFactoryTransactionManagerHana")
//	public HibernateTransactionManager transactionManager() {
//		HibernateTransactionManager txManager = new HibernateTransactionManager();
//		txManager.setSessionFactory(this.sessionFactoryHana);
//		return txManager;
//	}
//
//	@Bean
//	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//		return new PersistenceExceptionTranslationPostProcessor();
//	}
//
//}
