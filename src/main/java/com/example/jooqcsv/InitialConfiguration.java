package com.example.jooqcsv;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

@Configuration
public class InitialConfiguration {

	@Autowired
	private Environment environment;
	 
	@Bean
	public DataSource dataSource() {
	    JdbcDataSource dataSource = new JdbcDataSource();
	 
	    dataSource.setUrl(environment.getRequiredProperty("db.url"));
	    dataSource.setUser(environment.getRequiredProperty("db.username"));
	    dataSource.setPassword(environment.getRequiredProperty("db.password"));

	    return dataSource; 
	}
	
	@Bean
	public DataSourceConnectionProvider connectionProvider() {
	    return new DataSourceConnectionProvider
	      (new TransactionAwareDataSourceProxy(dataSource()));
	}	
	
	@Bean
	public ExceptionTranslator exceptionTransformer() {
	    return new ExceptionTranslator();
	}
	
	@Bean
	public DefaultDSLContext dsl() {
	    return new DefaultDSLContext(configuration());
	}
	
	@Bean
	public DefaultConfiguration configuration() {
	    DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
	    jooqConfiguration.set(connectionProvider());
	    jooqConfiguration
	      .set(new DefaultExecuteListenerProvider(exceptionTransformer()));
	 
	    return jooqConfiguration;
	}	
}
