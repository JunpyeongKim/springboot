package com.example.config;


// dummy
public class SecurityConfig {

}


//import com.example.service.user.LoginUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
////@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
////    @Value("${spring.h2.console.path}")
////    private String h2ConsolePath;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        super.configure(http);
//
//        /*
//        // H2
//        http.authorizeRequests()
//                .antMatchers("/h2-console/**").permitAll();
//        //TODO: There was an unexpected error (type=Forbidden, status=403).
//        //      Invalid CSRF Token 'null' was found on the request parameter '_csrf' or header 'X-CSRF-TOKEN'.
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//
//        // Swagger
//        http.authorizeRequests()
//                .antMatchers("/swagger-ui.html/**").permitAll()
//                .antMatchers("/swagger-resources/**").permitAll()
//                .antMatchers("/v2/api-docs/**").permitAll();
//
//        // Static resources
////        http.authorizeRequests()
////                .antMatchers("/css/**", "/js/**", "/images/**", "/resources/**", "/webjars/**").permitAll();
//
//
//        // Others
//        http.authorizeRequests()
//                .anyRequest().authenticated();
////        */
//
//
//        http.httpBasic();
//
//        http.csrf().disable();
//
//        http.authorizeRequests()
//                .antMatchers("/h2-console/**").permitAll();
//        http.headers().frameOptions().disable();
//
//
////        http.authorizeRequests()
////                .antMatchers("/cors/**").permitAll()
////                .anyRequest().authenticated().and().csrf()
////                .csrfTokenRepository(csrfTokenRepository()).and()
////                .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
//
//        http.authorizeRequests()
//                .antMatchers(
//                        "/swagger-ui.html/**",
//                        "/swagger-resources/**",
//                        "/v2/api-docs/**",
//                        "/webjars/**",
//                        "/v0.1/**",
//                        "/api/**",
//                        "/v1/**"
//                ).permitAll()
//                .anyRequest().authenticated();  //.and()
////                .csrf()
////                .csrfTokenRepository(csrfTokenRepository()).and()
////                .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
//
//        http.formLogin()
//                .loginProcessingUrl("/v0.1/auth/login")
////                .loginPage("http://localhost:3000/#/auth/login")
//                .failureUrl("http://localhost:3000/#/auth/login")
//////                .defaultSuccessUrl("http://localhost:3000/#/", true)
//                .usernameParameter("username").passwordParameter("password");
//
////        http.logout()
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
////                .logoutSuccessUrl("http://localhost:3000/#/auth/login");
//
//        // Filter
////        http.addFilterBefore(new DemoAuthenticationFilter(), BasicAuthenticationFilter.class);
//
//        // Session
////        http.sessionManagement().sessionAuthenticationStrategy(SessionCreationPolicy.STATELESS);
//
//        // Exception
//        // http://stackoverflow.com/questions/21633555/how-to-inject-authenticationmanager-using-java-configuration-in-a-custom-filter
////        http.exceptionHandling()
////                .authenticationEntryPoint(new AuthenticationEntryPoint() {
////                    @Override
////                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
////                        if (authException instanceof LockedException) {
////                            response.setStatus(HttpStatus.LOCKED.value());
////                        }
////                    }
////                })
////                .authenticationEntryPoint(new Http403ForbiddenEntryPoint())
////                .accessDeniedHandler(new AccessDeniedHandler() {
////                    @Override
////                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
////                        String test;
////                        if (accessDeniedException != null) {
////                            test = "accessDenied";
////                        }
////                    }
////                });
//    }
//
//    /*
//    @Autowired
//    UserService userService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
//
////        auth.authenticationProvider(demoAuthenticationProvider);
//        auth.authenticationProvider(new AuthenticationProvider() {
//            @Override
//            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
////                return null;
//
//                String username = authentication.getName();
//                String password = (String) authentication.getCredentials();
//                User user = userService.findOneByUsername(username);
//                if (user != null) {
////                    httpStatus = HttpStatus.UNAUTHORIZED;    // 401
//
//                    if (user.getPassword().equals(password)) {
//                        if (user.isLocked()) {
//                            // LockedException
////                            httpStatus = HttpStatus.LOCKED; // 423
////                            loginResponse = user;
//                            throw new LockedException(username);
//                        } else {
////                            httpStatus = HttpStatus.OK;
////
////                            authInfo = getAuth(user);
////                            user.accessSucceeded(true, authInfo.session, authInfo.token);
////                            loginResponse = userService.updateUserMetaInfo(user);
//                            user.accessSucceeded(true, "dummy-session", "dummy-token");
//                            userService.updateUserMetaInfo(user);
//                        }
//
//                    } else {
//                        if (user.isLocked()) {
//                            // LockedException
////                            httpStatus = HttpStatus.LOCKED;
////                            loginResponse = user;
//                            throw new LockedException(username);
//                        } else {
////                            httpStatus = user.loginFailed();
////                            loginResponse = userService.updateUserMetaInfo(user);
//                            user.loginFailed();
//                            userService.updateUserMetaInfo(user);
//                            throw new BadCredentialsException(username);
//                        }
//                    }
//
//                    return new UsernamePasswordAuthenticationToken(username, password, null);
//
//                } else {
////                    return null;
//                    throw new UsernameNotFoundException(username);
//                }
//            }
//
//            @Override
//            public boolean supports(Class<?> authentication) {
//                return true;
//            }
//        });
//    }
//    */
//
//    //    private Filter csrfHeaderFilter() {
////        return new OncePerRequestFilter() {
////            @Override
////            protected void doFilterInternal(HttpServletRequest request,
////                                            HttpServletResponse response, FilterChain filterChain)
////                    throws ServletException, IOException {
////                CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
////                        .getName());
////                if (csrf != null) {
////                    Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
////                    String token = csrf.getToken();
////                    if (cookie == null || token != null
////                            && !token.equals(cookie.getValue())) {
////                        cookie = new Cookie("XSRF-TOKEN", token);
////                        cookie.setPath("/");
////                        response.addCookie(cookie);
////                    }
////                }
////                filterChain.doFilter(request, response);
////            }
////        };
////    }
////
////    private CsrfTokenRepository csrfTokenRepository() {
////        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
////        repository.setHeaderName("X-XSRF-TOKEN");
////        return repository;
////    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
////
//////        auth.authenticationProvider()
////    }
//
//    @Configuration
//    static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
//        @Autowired
//        LoginUserDetailsService loginUserDetailsService;
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
////            super.init(auth);
//
////            auth.inMemoryAuthentication()
////                    .withUser("a").password("a").roles("USER");
//
//            auth.userDetailsService(loginUserDetailsService);
//
////            auth.userDetailsService(loginUserDetailsService).passwordEncoder();
//        }
//
//
//    }
//}
