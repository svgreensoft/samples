package org.sversh.hw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
@Configuration
@Import({PersistenceJPAConfig.class, ServicesConfig.class /**WebAppConfig.class, PersistenceJPAConfig.class, PropertyConfig.class*/})
public class AppConfig {

}
