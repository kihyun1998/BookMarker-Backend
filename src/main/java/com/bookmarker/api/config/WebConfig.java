package com.bookmarker.api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean<?> corsConfigurationSource() {
        /// cors configuration 가져옴
        CorsConfiguration configuration = new CorsConfiguration();

        /// 오리진 모두 허용
        configuration.setAllowedOrigins(Arrays.asList("*"));
        
        /// 크리덴셜 true
        configuration.setAllowCredentials(true);
        
        /// 헤더 허용
        configuration.setAllowedHeaders(Arrays.asList(
                "Access-Control-Allow-Headers",
                "Access-Control-Allow-Origin",
                "Access-Control-Request-Method",
                "Access-Control-Request-Headers",
                "Origin",
                "Cache-Control",
                "Content-Type", 
                "Authorization"));
        
        /// 메서드 허용
        configuration.setAllowedMethods(Arrays.asList("POST", "DELETE", "GET", "PATCH", "PUT"));

        /// UrlBasedCorsConfigurationSource 클래스
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        
        /// configuration 값을 적용
        source.registerCorsConfiguration("/**", configuration);

        /// CorsFilter에 이 설정값을 적용
        FilterRegistrationBean<?> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
