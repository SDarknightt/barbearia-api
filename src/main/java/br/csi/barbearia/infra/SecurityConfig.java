package br.csi.barbearia.infra;

import br.csi.barbearia.filters.AutenticacaoFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AutenticacaoFilter autenticacaoFilter;

    public SecurityConfig(AutenticacaoFilter filtro) {
        this.autenticacaoFilter = filtro;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        return http
                .csrf(crsf-> crsf.disable())
                .sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth->
                        auth.requestMatchers(HttpMethod.POST,"/login").permitAll()
                                .requestMatchers(HttpMethod.POST,"/usuario").permitAll()
                                .requestMatchers(HttpMethod.GET, "/usuario").hasAnyAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/usuario").hasAnyAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/usuario").hasAnyAuthority("ROLE_ADMIN")

                                .requestMatchers(HttpMethod.POST, "/cliente").hasAnyAuthority("ROLE_ADMIN", "ROLE_FUNCIONARIO")
                                .requestMatchers(HttpMethod.PUT, "/cliente").hasAnyAuthority("ROLE_ADMIN", "ROLE_FUNCIONARIO")
                                .requestMatchers(HttpMethod.GET, "/cliente").hasAnyAuthority("ROLE_ADMIN", "ROLE_FUNCIONARIO")
                                .requestMatchers(HttpMethod.DELETE, "/cliente").hasAnyAuthority("ROLE_ADMIN", "ROLE_FUNCIONARIO")

                                .requestMatchers(HttpMethod.POST, "/corte").hasAnyAuthority("ROLE_ADMIN", "ROLE_FUNCIONARIO")
                                .requestMatchers(HttpMethod.PUT, "/corte").hasAnyAuthority("ROLE_ADMIN", "ROLE_FUNCIONARIO")
                                .requestMatchers(HttpMethod.GET, "/corte").hasAnyAuthority("ROLE_ADMIN", "ROLE_FUNCIONARIO")
                                .requestMatchers(HttpMethod.DELETE, "/corte").hasAnyAuthority("ROLE_ADMIN", "ROLE_FUNCIONARIO")

                                .requestMatchers(HttpMethod.POST, "/barbearia").hasAnyAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/barbearia").hasAnyAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.GET, "/barbearia").hasAnyAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/barbearia").hasAnyAuthority("ROLE_ADMIN")

                                .anyRequest().authenticated())
                .addFilterBefore(this.autenticacaoFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
        throws Exception{
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
