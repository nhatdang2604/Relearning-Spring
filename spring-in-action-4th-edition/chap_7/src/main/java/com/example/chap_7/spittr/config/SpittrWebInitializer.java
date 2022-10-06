package com.example.chap_7.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

public class SpittrWebInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {

    public static final String TEMP_DIR_LOCATION = "/tmp/spittr_uploads";
    private static final int MAX_FILE_SIZE = 2097152; //2mb
    private static final int MAX_REQUEST_SIZE = 4194304; //4mb
    private static final int FILE_SIZE_THRESHOLD = 0;   //0mb

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    private boolean createTempFolder() {
        return new File(TEMP_DIR_LOCATION).mkdir();
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        createTempFolder();
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        TEMP_DIR_LOCATION,
                        MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD)
        );
    }
}

