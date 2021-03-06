package com.example.boot.fileupload.demofileuploadboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import java.nio.charset.Charset;

@Configuration
@SpringBootApplication
public class DemoFileuploadBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFileuploadBootApplication.class, args);
    }

//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
//    }
//
//    @Bean
//    public Filter characterEncodingFilter() {
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//        return characterEncodingFilter;
//    }
}
