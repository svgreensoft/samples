package org.sversh.hw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.sversh.hw.data.dao.JpaDao;
import org.sversh.hw.service.ServicePackage;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
@Configuration
@ComponentScan(basePackageClasses = {ServicePackage.class, JpaDao.class})
public class ServicesConfig {

}
