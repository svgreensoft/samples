package org.sversh.hw.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
//@ComponentScan
public class PersistenceJPAConfig implements TransactionManagementConfigurer {

    private static final String DRIVER_CLASS_NAME = "org.hsqldb.jdbc.JDBCDriver";
    private static final String DB_URL = "jdbc:hsqldb:mem:homework";
    private static final String DB_USER = "sa";
    private static final String DB_PSWD = "";

    @Bean(name="entityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setPackagesToScan("org.sversh.hw.data");
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
        properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        properties.put("hibernate.cache.use_second_level_cache", "false");
        return properties;        
}


    @Override
    public JpaTransactionManager annotationDrivenTransactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(this.configureEntityManagerFactory().getObject());
        //txManager.setDataSource(getDataSource());
        return txManager ;
    }
    
//    @Bean
//    public PlatformTransactionManager annotationDrivenTransactionManager(){
//       JpaTransactionManager transactionManager = new JpaTransactionManager();
//       transactionManager.setEntityManagerFactory(
//               configureEntityManagerFactory().getObject() );
//       return transactionManager;
//    }
    
//    @Bean
//    public DriverManagerDataSource getDataSourceTemplate() {
//        DriverManagerDataSource dataSourceTemplate = new DriverManagerDataSource(DB_URL, DB_USER, DB_PSWD);
//        dataSourceTemplate.setDriverClassName(DRIVER_CLASS_NAME);
//        return dataSourceTemplate;
//    }
    
    
//    @Bean
//    public TransactionTemplate transactionTemplate() {
//        TransactionTemplate transactionTemplate = new TransactionTemplate();
//        transactionTemplate.setTransactionManager(annotationDrivenTransactionManager());
//        return transactionTemplate;
//    }    

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

}
