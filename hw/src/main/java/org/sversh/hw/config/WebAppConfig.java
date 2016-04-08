package org.sversh.hw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.sversh.hw.controller")
public class WebAppConfig {

}
