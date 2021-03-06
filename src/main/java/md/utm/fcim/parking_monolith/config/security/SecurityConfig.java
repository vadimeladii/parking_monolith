package md.utm.fcim.parking_monolith.config.security;

import md.utm.fcim.parking_monolith.business.impl.UserSecurityBusiness;
import md.utm.fcim.parking_monolith.config.filter.StatelessAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by veladii on 03/17/2018
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"
    };

    @Autowired
    private UserSecurityBusiness userSecurityBusiness;

    @Autowired
    private StatelessAuthFilter statelessAuthFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.POST, "/user/login").permitAll()
//                test start
                .antMatchers("/parking-lot").permitAll()
                .antMatchers("/parking-lot/*").permitAll()
                .antMatchers("/user").permitAll()
                .antMatchers("/user/*").permitAll()
                .antMatchers("/notification").permitAll()
                .antMatchers("/notification/send/*").permitAll()
                .antMatchers("/camera").permitAll()
                .antMatchers("/camera/*").permitAll()
                .antMatchers("/car").permitAll()
                .antMatchers("/car/*").permitAll()
                .antMatchers("/entry/increment").permitAll()
                .antMatchers("/entry/decrement*").permitAll()
//                test end
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(statelessAuthFilter, UsernamePasswordAuthenticationFilter.class);
    }

    private PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityBusiness)
                .passwordEncoder(bCryptPasswordEncoder());
    }
}
