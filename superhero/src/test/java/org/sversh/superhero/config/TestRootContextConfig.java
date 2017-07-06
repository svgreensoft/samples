package org.sversh.superhero.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
 * @since Apr 8, 2016
 *
 */
//@Primary
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories
//@ComponentScan("org.sversh.superhero")
public class TestRootContextConfig {

    private static final String DRIVER_CLASS_NAME = "org.hsqldb.jdbc.JDBCDriver";
    private static final String DB_URL = "jdbc:hsqldb:mem:homework";
    private static final String DB_USER = "sa";
    private static final String DB_PSWD = "";

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
      dataSource.setDriverClassName(DRIVER_CLASS_NAME);
      dataSource.setUrl(DB_URL);
      dataSource.setUsername(DB_USER);
      dataSource.setPassword(DB_PSWD);
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
