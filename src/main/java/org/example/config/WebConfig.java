package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }   /* Конфигурационные классы для бизнес-логики приложения */

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ SpringConfig.class };
    }   /* Конфигурационные классы для Spring MVC */

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
