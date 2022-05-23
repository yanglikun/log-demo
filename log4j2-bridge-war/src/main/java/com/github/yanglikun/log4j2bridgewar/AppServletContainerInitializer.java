package com.github.yanglikun.log4j2bridgewar;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

public class AppServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("AppServletContainerInitializer..");
        Log4j2BridgeMain.main(null);
    }
}
