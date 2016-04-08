package org.sversh.hw.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author Sergey Vershinin
 * @since Apr 8, 2016
 *
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootContextConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebAppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    // @Override
    // public void onStartup(ServletContext container) {
    // // Create the 'root' Spring application context
    // AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    // rootContext.register(RootContextConfig.class);
    //
    // // Manage the lifecycle of the root application context
    // container.addListener(new ContextLoaderListener(rootContext));
    //
    // // Create the dispatcher servlet's Spring application context
    // AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
    // dispatcherContext.register(WebAppConfig.class);
    //
    // // Register and map the dispatcher servlet
    // ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",
    // new DispatcherServlet(dispatcherContext));
    // dispatcher.setLoadOnStartup(1);
    // dispatcher.addMapping("/");
    // }
}
