package com.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.app.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //aqui se definen las condiciones para la autenticacion
        return httpSecurity
            .csrf(csrf -> csrf.disable())// esta proteccion se ocupa para mvc no para REST
            .httpBasic(Customizer.withDefaults()) //se utiliza cuando usamos usuario y contrasenia
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // hay otra forma de usar esto atraves de Preautorize en los controladores
            // .authorizeHttpRequests(http -> {
            //     //endpoints publicos
            //     http.requestMatchers(HttpMethod.GET,"/auth/hello").permitAll();
            //     //endpoints privados
            //     http.requestMatchers(HttpMethod.GET,"/auth/hello-secured").hasAuthority("CREATE");
            //     //endpoints no especificados
            //     http.anyRequest().denyAll();
            // })
            .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
        //este es nuestro proveedor
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        // provider.setUserDetailsService(userDetailsService());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    // @Bean
    // public UserDetailsService userDetailsService(){
    //     // hipoteticamente lo trajimos de una base de datos, pero en este momento se esta guardando en memoria
    //     List<UserDetails> userDetailsList = new ArrayList<>();
        
    //     userDetailsList.add(
    //         User.withUsername("Alejandro")
    //         .password("1234")
    //         .roles("ADMIN")
    //         .authorities("READ","CREATE")
    //         .build());
        
    //     userDetailsList.add(
    //         User.withUsername("Daniel")
    //         .password("1234")
    //         .roles("USER")
    //         .authorities("READ")
    //         .build());

    //     return new InMemoryUserDetailsManager(userDetailsList);
    // }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();//solo para pruebas lo que realmentese usa es Bcrypt
    }

    // public static void main(String[] args) {
    //     System.out.println(new BCryptPasswordEncoder().encode("1234"));
    // }
}
