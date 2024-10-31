package com.dev6.Webfoodapp.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Autorise l'accès public à ces endpoints spécifiques
                .antMatchers("/aliments", "/aliment/**").permitAll() 
                
                // Exige une authentification pour les opérations CRUD
                .antMatchers("/createAliment", "/updateAliment/**", "/deleteAliment/**").authenticated()
                
                // Toutes les autres requêtes nécessitent une authentification
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login") // Page de connexion personnalisée
                .defaultSuccessUrl("/", true) // Redirige vers la page d'accueil après connexion
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
}
