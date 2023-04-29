package com.cloudit.project.config;

import com.cloudit.project.Filters.CorsFilter;
import com.cloudit.project.JwtUtils.JwtFilter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SecurityConfig {
    final JwtFilter jwtFilter;
    //final CustomUserDetailsService userDetailsService;
        /*@Bean
        public InMemoryUserDetailsManager userDetailsService() {
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username("user")
                    .password("1111")
                    .roles("USER")
                    .build();
            UserDetails user2 = User.withDefaultPasswordEncoder()
                    .username("user2")
                    .password("2222")
                    .roles("USER")
                    .build();
            return new InMemoryUserDetailsManager(user,user2);
        }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*http
                .authorizeHttpRequests().requestMatchers("/ws/**","/api/v1/login").permitAll()
                .and()
                .authorizeHttpRequests().anyRequest().authenticated()
                .and()
                .httpBasic(withDefaults());
        http.anonymous().disable();*/
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                .authorizeHttpRequests().requestMatchers("/api/v1/login").permitAll().and()
                .authorizeHttpRequests().requestMatchers("/cloudit/**").permitAll().and()
                                .authorizeHttpRequests()
                                        .anyRequest().authenticated();
        http.csrf().disable();
        http.anonymous().disable();
        http
                .securityContext((securityContext) ->securityContext
                        .requireExplicitSave(false)
                );
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    { return authenticationConfiguration.getAuthenticationManager();}

    @Bean
    public PasswordEncoder passwordEncoder()
    { return new BCryptPasswordEncoder(); }
}
