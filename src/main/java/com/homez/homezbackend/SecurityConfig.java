package com.homez.homezbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;

import com.homez.homezbackend.filter.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements ISecurityConfig {

        @Autowired
        private JWTAuthorizationFilter jwtAuthorizationFilter;

        @Override
        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Override
        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
                return configuration.getAuthenticationManager();
        }

        @Override
        @Bean
        public SecurityFilterChain configure(HttpSecurity http) throws Exception {

                http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                                .csrf(csrf -> csrf.ignoringRequestMatchers(ignoreSpecificRequests()))
                                .authorizeHttpRequests(authRequest -> authRequest
                                                .requestMatchers("/api/homez/propiedad/**",
                                                                "/api/homez/departamento/**",
                                                                "/api/homez/tipo/**",
                                                                "/api/homez/message/**",
                                                                "/api/homez/calpropiedad/get",
                                                                "/chat/**",
                                                                "/topic/**",
                                                                "/chat-socket/**",
                                                                "/app/**",
                                                                "/api/homez/estado/**",
                                                                "/api/homez/message/**",
                                                                "/api/homez/municipio/**",
                                                                "/api/homez/tipoingreso/**",
                                                                "/api/homez/jwt/security/autenticar/**")
                                                .permitAll()
                                                .anyRequest().authenticated());

                return http.build();
        }

        private RequestMatcher ignoreSpecificRequests() {
                return new OrRequestMatcher(
                                // new AntPathRequestMatcher("/indicadoressuim/api/autenticacion"),
                                // new AntPathRequestMatcher("/indicadoressuim/api/peticion-mes"),
                                new AntPathRequestMatcher("/api/homez/jwt/security/autenticar/**", HttpMethod.GET.name()),
                                new AntPathRequestMatcher("/api/homez/jwt/security/autenticar/**", HttpMethod.POST.name()),
                                new AntPathRequestMatcher("/api/homez/jwt/security/autenticar/**", HttpMethod.PUT.name()),
                                new AntPathRequestMatcher("/api/homez/jwt/security/autenticar/**", HttpMethod.DELETE.name()),
                                new AntPathRequestMatcher("/api/homez/jwt/security/usuario/**", HttpMethod.GET.name()),
                                new AntPathRequestMatcher("/api/homez/jwt/security/usuario/**", HttpMethod.POST.name()),
                                new AntPathRequestMatcher("/api/homez/jwt/security/usuario/**", HttpMethod.PUT.name()),
                                new AntPathRequestMatcher("/api/homez/jwt/security/usuario/**", HttpMethod.DELETE.name()),
                                new AntPathRequestMatcher("/chat-socket/**", HttpMethod.GET.name()),
                                new AntPathRequestMatcher("/chat-socket/**", HttpMethod.POST.name()),
                                new AntPathRequestMatcher("/chat-socket/**", HttpMethod.PUT.name()),
                                new AntPathRequestMatcher("/chat-socket/**", HttpMethod.DELETE.name()),
                                new AntPathRequestMatcher("/api/homez/**", HttpMethod.GET.name()),
                                new AntPathRequestMatcher("/api/homez/**", HttpMethod.POST.name()),
                                new AntPathRequestMatcher("/api/homez/**", HttpMethod.PUT.name()),
                                new AntPathRequestMatcher("/api/homez/**", HttpMethod.DELETE.name()));
        }
}
