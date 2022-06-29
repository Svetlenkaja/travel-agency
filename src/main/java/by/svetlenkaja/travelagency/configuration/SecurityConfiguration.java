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

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

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
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                // The pages does not require login
                .authorizeRequests().antMatchers("/", "/home", "/login", "/logout", "/tours", "/register").permitAll()
                .antMatchers("/tours/createTour", "/bookings").hasAnyRole("ADMIN", "MANAGER")
                // For ADMIN only
                .antMatchers("/createUser", "/users").access("hasRole('ADMIN')")
                .antMatchers("/bookings/myBooking").access("hasRole('CLIENT')")
                .and()
                // Config for Login Form
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/home")
                .and()
                // Config for Logout Page
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                // When the user has logged, but access a page that requires role
                // AccessDeniedException will throw.
                .exceptionHandling().accessDeniedPage("/403");
    }
}
