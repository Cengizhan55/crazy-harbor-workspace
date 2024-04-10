package com.crazycoder.crazyharborbff.config.security;

import com.crazycoder.crazyharborbff.config.security.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

/**
 * we used to WebSecurityConfigurerAdapter but with the spring 3.0 , we don't.
 * spring security is secure by default we expose endpoints
 * create your own Authentication subclasses
 * dont use UsernamePasswordAuthenticationToken
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(AuthenticationProvider authenticationProvider, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()

                .authorizeHttpRequests().requestMatchers("/auth/v1/**").permitAll()
                .anyRequest().permitAll() // todo -> change this in production .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


































    /*
    private final HarborUserDetailService harborUserDetailService;

    public SecurityConfig(HarborUserDetailService harborUserDetailService) {
        this.harborUserDetailService = harborUserDetailService;
    }

     */

    /*

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

       // var authManager = new ProviderManager(new TestAuthenticationProvider(List.of("password", "crazypassword", "sifre")));
       // authManager.setAuthenticationEventPublisher(publisher);
        return http
                .csrf().disable()
                .authorizeHttpRequests(
                        auth -> auth
                                .anyRequest()
                                .permitAll()
                               // .anyRequest().authenticated()

                )
            //    .formLogin(Customizer.withDefaults())
                //  .oauth2Login(Customizer.withDefaults())
             //   .addFilterBefore(new TestFilter(authManager), UsernamePasswordAuthenticationFilter.class)
              //  .authenticationProvider(new CengizhanAuthenticationProvider())
                .build();
    }

     */


    /*
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("cengizhan")
                        .password("{noop}password")
                        .authorities("ROLE_ADMIN")
                        .build()
        );
    }

     */
   /*
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();

    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

     */

    /*
    @Bean
    ApplicationListener<AuthenticationSuccessEvent> successEventApplicationListener() {
        return event -> {
            System.out.println("You have succesfully logged in. "
                    + event.getAuthentication().getClass().getSimpleName() + " and "
                    + event.getAuthentication());
        };
    }

     */

}
