package com.example.apirestpersistencia.Seguretat;

import com.example.apirestpersistencia.Model.serveis.ElMeuUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfiguracioSeguretatWeb extends WebSecurityConfigurerAdapter {
    private final ElMeuAuthenticationEntryPoint elmeuEntryPoint;
    private final ElMeuUserDetailsService elmeuUserDetailsService;
    private final PasswordEncoder xifrat;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(elmeuUserDetailsService).passwordEncoder(xifrat);

        //auth.inMemoryAuthentication().passwordEncoder(xifrat).withUser("Joan").password(xifrat.encode("123456")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//per poder accedir al h2-console
                //  .authorizeRequests().antMatchers("/").permitAll().and()
                //  .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                // .and()
                .csrf().disable()
                // .headers().frameOptions().disable()
                // .and()
                .authorizeRequests()
                .anyRequest().authenticated();

        /*http.cors() //amb aquesta l??nia evitem la configuraci?? custom del cors en un fitxer a part
                .and()
                .httpBasic()
                .authenticationEntryPoint(elmeuEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/me/**").hasRole("ADMIN") //per fer proves del forbidden
                .antMatchers(HttpMethod.GET, "/users/**", "/begudes/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/users/**", "/begudes/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/begudes/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/begudes/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/begudes/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated();*/
        // .and()
        // .csrf().disable();
    }
}
