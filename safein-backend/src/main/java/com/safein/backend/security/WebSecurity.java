package com.safein.backend.security;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.safein.backend.service.UsuarioDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurity {

	
	private UsuarioDetailsServiceImpl usuarioDetails;
	
	private JwtAuthEntryPoint jwtAuthEntryPoint;

	@Autowired
	public WebSecurity(UsuarioDetailsServiceImpl usuarioDetailsServiceImpl, JwtAuthEntryPoint jwtAuthEntryPoint) {
		this.usuarioDetails = usuarioDetailsServiceImpl;
		this.jwtAuthEntryPoint = jwtAuthEntryPoint;
	}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		/*
		 * 1. Se desactiva el uso de cookies 2. Se activa la configuración CORS con los
		 * valores por defecto 3. Se desactiva el filtro CSRF 4. Se indica que el login
		 * no requiere autenticación 5. Se indica que el resto de URLs esten securizadas
		 */
		 http
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
         .cors()
         .and()
         .csrf().disable()
         .exceptionHandling()
         .authenticationEntryPoint(jwtAuthEntryPoint)
         .and()
         .authorizeHttpRequests()
             .requestMatchers(HttpMethod.POST, "/register").permitAll()
             .requestMatchers(HttpMethod.POST, "/login").permitAll()
             .anyRequest().authenticated()
             .and()
             .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		 
		 return http.build();
	}
	
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration auth_config) throws Exception {
    	return auth_config.getAuthenticationManager();
    }
    
	@Bean
	PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    @Bean
    JWTAuthenticationFilter jwtAuthenticationFilter() {
    	return new JWTAuthenticationFilter();
    }

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}