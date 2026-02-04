package com.example.ecommerce.config;

import com.example.ecommerce.service.JwtService;
//import com.example.spring_security.service.JWTService;
//import com.example.spring_security.service.MyUserDetailsService;
import com.example.ecommerce.service.MyUserDetailsService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService service;

    @Autowired
    private ApplicationContext context;


    //    @Override
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String authHeader = request.getHeader("Authorization");
//
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//
//            String token = authHeader.substring(7);
//
//            if (SecurityContextHolder.getContext().getAuthentication() == null) {
//
//                Claims claims = service.extractAllClaims(token);
//
//                String username = claims.getSubject();
//                String role = claims.get("role", String.class);
//
//                List<GrantedAuthority> authorities =
//                        List.of(new SimpleGrantedAuthority("ROLE_" + role));
//
//                UsernamePasswordAuthenticationToken authToken =
//                        new UsernamePasswordAuthenticationToken(
//                                username,
//                                null,
//                                authorities
//                        );
//
//                authToken.setDetails(
//                        new WebAuthenticationDetailsSource().buildDetails(request)
//                );
//
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        String username = service.extractUserName(token);
        String role = service.extractRole(token); // 👈 IMPORTANT
        System.out.println("JWT FILTER HIT");
        System.out.println("Username from token = " + username);
        System.out.println("Role from token = " + role);


        if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            SimpleGrantedAuthority authority =
                    new SimpleGrantedAuthority("ROLE_" + role);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            List.of(authority)
                    );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }



}