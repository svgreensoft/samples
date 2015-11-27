package org.sversh.ssui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author Sergey Vershinin</a>
 * @since Nov 27, 2015
 *
 */
@Configuration
@EnableWebMvc
@Import(SwaggerConfig.class)
public class WebConfig extends WebMvcConfigurerAdapter {

}
