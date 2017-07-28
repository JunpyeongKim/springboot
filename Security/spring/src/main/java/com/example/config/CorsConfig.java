package com.example.config;



///* dummy
public class CorsConfig {

}
//*/

/*
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
//                super.addCorsMappings(registry);
                registry.addMapping("/**");
            }
        };
    }
}
//*/


/* JavaConfig 1 & 2
@Configuration
@EnableWebMvc
public class CorsConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 1
//        registry.addMapping("/**");

        // 2
        registry.addMapping("/**")
                .allowedOrigins("*")
//			.allowedMethods("PUT", "DELETE")
                .allowedMethods("*")
//			.allowedHeaders("header1", "header2", "header3")
//			.exposedHeaders("header1", "header2")
                .allowCredentials(false).maxAge(3600);
    }
}
// */


/* Spring Boot integration
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 1
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");

//                // 2
//                registry.addMapping("/cors/**")
//                        .allowedOrigins("*")
////			.allowedMethods("PUT", "DELETE")
//                        .allowedMethods("*")
////			.allowedHeaders("header1", "header2", "header3")
////			.exposedHeaders("header1", "header2")
//                        .allowCredentials(false).maxAge(3600);
//
//                // 3
//                registry.addMapping("/resources/**")
//                        .allowedOrigins("http://localhost:3000")
//                        .allowedMethods("*")
//                        .allowCredentials(false).maxAge(3600);
            }
        };
    }
}
// */


/* Filter based CORS support ???
public class CorsConfig {

	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(false);
//		config.addAllowedOrigin("http://domain1.com");
        config.addAllowedOrigin("http://localhost:3000");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}
}
// */

/* With Spring Security
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With, Origin, X-Auth-Token, X-XSRF-TOKEN, X-User-Id");
        response.addHeader("Access-Control-Expose-Headers", "X-Auth-Token");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
// */

