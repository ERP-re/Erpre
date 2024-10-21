package com.project.erpre.config;

import com.project.erpre.auth.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;

// 시큐리티 설정 및 CORS, 정적 리소스 핸들링 설정
@Configuration
@EnableWebSecurity // 시큐리티 설정파일을 시큐리티 필터에 등록
public class WebSecurityConfig {

    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    public WebSecurityConfig(JwtAuthorizationFilter jwtAuthorizationFilter) {
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors() // CORS 설정 활성화
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT를 사용하므로 세션을 사용하지 않음
                .and()
                .authorizeRequests()
                    .antMatchers("/static/**", "/bundle/**", "/img/**", "/css/**", "/fonts/**").permitAll()
                    .antMatchers("/login", "/**").permitAll() // 로그인 앤드포인트는 인증 없이 접근 허용
                    .antMatchers("/user/**").hasAnyRole("staff", "admin")
                    .antMatchers("/admin/**").hasRole("admin")
                    .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
                .and()
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class); // JWT 필터 등록

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

    // CORS(Cross-Origin Resource Sharing) 설정
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000", "http://localhost:8787")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                configurer.defaultContentType(MediaType.APPLICATION_JSON);
            }

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                configurer.setUseSuffixPatternMatch(false);
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/bundle/**")
                        .addResourceLocations("classpath:/static/bundle/")
                        .setCachePeriod(3600)
                        .resourceChain(true)
                        .addResolver(new PathResourceResolver());

                registry.addResourceHandler("/img/**")
                        .addResourceLocations("classpath:/static/img/")
                        .setCachePeriod(3600)
                        .resourceChain(true)
                        .addResolver(new PathResourceResolver());

                registry.addResourceHandler("/css/**")
                        .addResourceLocations("classpath:/static/css/")
                        .setCachePeriod(3600)
                        .resourceChain(true)
                        .addResolver(new PathResourceResolver());

                registry.addResourceHandler("/fonts/**")
                        .addResourceLocations("classpath:/static/fonts/")
                        .setCachePeriod(3600)
                        .resourceChain(true)
                        .addResolver(new PathResourceResolver());
            }


        };
    }
}
