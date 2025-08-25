package com.gm.web;

import java.util.Locale;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    LocaleResolver localeResolver() {
        var clr = new CookieLocaleResolver();
        clr.setDefaultLocale(Locale.forLanguageTag("en"));
        return clr;
    }

    @Bean
    LocaleChangeInterceptor localeChangeInterceptor(){
        var lci=new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    @SuppressWarnings("null")
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    @SuppressWarnings("null")
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
    }
}
