package by.svetlenkaja.travelagency.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
//    private final BCryptPasswordEncoder passwordEncoder;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .httpBasic()
//                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/tours", "/createUser").permitAll()
                .antMatchers("/createTour", "/users").hasAnyRole("ADMIN")
//                .antMatchers("/createTour", "/users").access("hasRole('ADMIN')");
//                .antMatchers("/createTour", "/users").authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/home")
                .and()
                .logout()
                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
//                .logout().logoutSuccessUrl("/login?logout")
//                .exceptionHandling().accessDeniedPage("/403")
//                .and()
//                .csrf();
    }
}
