package com.charlires.example.web.config;

import com.charlires.example.config.JpaConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by carlos_andonaegui on 3/25/14.
 */
@Configuration
public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // Bootstrap repositories in root application context
        AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
        rootCtx.register(JpaConfig.class); // Include JPA entities, Repositories
        servletContext.addListener(new ContextLoaderListener(rootCtx));

        // Enable Spring Data REST in the DispatcherServlet
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(RestConfig.class); // Child class of RepositoryRestMvcConfiguration

        // Enable Spring Security in the ServletContext
//        servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
//                .addMappingForUrlPatterns(null, false, "/*");

        FilterRegistration.Dynamic enc = servletContext.addFilter("encodingFilter",
                new CharacterEncodingFilter());
        enc.setInitParameter("encoding", "UTF-8");
        enc.setInitParameter("forceEncoding", "true");
        enc.addMappingForUrlPatterns(null, true, "/*");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webCtx);
        ServletRegistration.Dynamic reg = servletContext.addServlet("rest-exporter", dispatcherServlet);
        reg.setLoadOnStartup(1);
        reg.addMapping("/api/*");
    }

}
