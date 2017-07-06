package org.sversh.superhero.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author Sergey Vershinin
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan("org.sversh.superhero")
@PropertySource("classpath:/properties/app-${shenv}.properties")
public class RootContextConfig {
    
    @Autowired
    Environment env;

    @Bean(name="entityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setPackagesToScan("org.sversh.superhero.data");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        return entityManagerFactoryBean;
    }
    
    
    @Bean
    public DataSource getDataSource() {
        
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(env.getProperty("sh.jdbc.driverClass"));
      dataSource.setUrl(env.getProperty("sh.jdbc.url"));
      dataSource.setUsername(env.getProperty("sh.jdbc.username"));
      dataSource.setPassword(env.getProperty("sh.jdbc.password"));
      Properties connectionProperties = new Properties();
      connectionProperties.setProperty("serverTimezone", 
              env.getProperty("sh.jdbc.server.timezone"));
    dataSource.setConnectionProperties(connectionProperties);
      return dataSource;
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        properties.put("hibernate.cache.use_second_level_cache", "false");
        return properties;        
}

    @Bean
    public JpaTransactionManager annotationDrivenTransactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(this.configureEntityManagerFactory().getObject());
        return txManager ;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

}
