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
         //Filtros de utilidades
             .requestMatchers(HttpMethod.POST, "/register").permitAll()
             .requestMatchers(HttpMethod.POST, "/login").permitAll()
             //Filtros de countries
             .requestMatchers(HttpMethod.GET, "/countries").hasAnyAuthority("admin", "user", "editor")
             .requestMatchers(HttpMethod.GET, "/countries/asc").hasAnyAuthority("admin", "user", "editor")
             .requestMatchers(HttpMethod.GET, "/countries/desc").hasAnyAuthority("admin", "user", "editor")
             .requestMatchers(HttpMethod.GET, "/countries/id/**").hasAnyAuthority("admin", "user", "editor")
             .requestMatchers(HttpMethod.GET, "/countries/countrycode/**").hasAnyAuthority("admin", "user", "editor")
             .requestMatchers(HttpMethod.POST, "/countries").hasAnyAuthority("admin", "editor")
             .requestMatchers(HttpMethod.PUT, "/countries").hasAnyAuthority("admin", "editor")
             .requestMatchers(HttpMethod.DELETE, "/countries/**").hasAnyAuthority("admin")
             //Filtros de hotels
             .requestMatchers(HttpMethod.GET,"/hotels").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/hotels/id/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/hotels/cities/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/hotels/security_level/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/hotels/energy_suficient/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.POST,"/hotels").hasAnyAuthority("admin","editor")
             .requestMatchers(HttpMethod.PUT,"/hotels/**").hasAnyAuthority("admin","editor")
             //Filtros de Customers
             .requestMatchers(HttpMethod.GET,"/customers").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/customers/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/customers/doc/**/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.POST,"/customers").hasAnyAuthority("admin","editor")
             .requestMatchers(HttpMethod.PUT,"/customer/**").hasAnyAuthority("admin","editor")
             .requestMatchers(HttpMethod.GET,"/customers/media/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/customers/email/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.DELETE,"/customers/**").hasAnyAuthority("admin")
             //Filters Cities
             .requestMatchers(HttpMethod.GET,"/cities").permitAll()
             .requestMatchers(HttpMethod.GET,"/cities/id/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/cities/name/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/cities/country/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.POST,"/cities").hasAnyAuthority("admin","editor")
             .requestMatchers(HttpMethod.PUT,"/cities/**").hasAnyAuthority("admin","editor")
             //Filter SUser
             .requestMatchers(HttpMethod.GET,"/susers").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/susers/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.POST,"/register").hasAnyAuthority("admin")
             .requestMatchers(HttpMethod.PUT,"/susers/**").hasAnyAuthority("admin")
             .requestMatchers(HttpMethod.DELETE,"/susers/**").hasAnyAuthority("admin")
             //Filter Rooms
             .requestMatchers(HttpMethod.GET,"/rooms").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/rooms/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/rooms/hotels/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/rooms/numpeople/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/rooms/inettype/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/rooms/smoke/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/rooms/terrace/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/rooms/1/numpers/2").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.POST,"/rooms").hasAnyAuthority("admin","editor")
             .requestMatchers(HttpMethod.PUT,"/rooms/**").hasAnyAuthority("admin","editor")
             .requestMatchers(HttpMethod.DELETE,"/rooms").hasAnyAuthority("admin")  
             //Filter Handles/Bookings
             .requestMatchers(HttpMethod.GET,"/booking").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/booking/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/booking/user/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/booking/customer/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/booking/rooms/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/booking/hotel/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/booking/handles").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/booking/handles/customer_asc").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/booking/handles/customer_desc").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.GET,"/booking/handle/**").hasAnyAuthority("admin","user","editor")
             .requestMatchers(HttpMethod.POST,"/booking").hasAnyAuthority("admin","editor")
             .requestMatchers(HttpMethod.POST,"/handle").hasAnyAuthority("admin","editor")
             .requestMatchers(HttpMethod.PUT,"/booking/**").hasAnyAuthority("admin","editor")
             .requestMatchers(HttpMethod.PUT,"/handle/**").hasAnyAuthority("admin","editor")
             .requestMatchers(HttpMethod.DELETE,"/booking/handles/**").hasAnyAuthority("admin")
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