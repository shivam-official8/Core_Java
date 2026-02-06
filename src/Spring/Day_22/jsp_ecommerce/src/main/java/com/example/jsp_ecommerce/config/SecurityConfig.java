package com.example.jsp_ecommerce.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .dispatcherTypeMatchers(
                                DispatcherType.FORWARD
//                                DispatcherType.ERROR
                        ).permitAll()
                        .requestMatchers(
                                "/login",
                                "/signup",
                                "/register",
                                "/css/**",
                                "/js/**"
                        ).permitAll()

                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/customer/**").hasRole("CUSTOMER")

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")              // GET → JSP
                        .loginProcessingUrl("/doLogin")  // POST → Security
                                .defaultSuccessUrl("/home", true)

//                        .defaultSuccessUrl("/customer/home", true)
                        .permitAll()                     // ⭐ IMPORTANT
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                );

        return http.build();
    }
}
