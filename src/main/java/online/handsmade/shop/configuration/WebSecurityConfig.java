package online.handsmade.shop.configuration;

import online.handsmade.shop.repo.UserRepo;
import online.handsmade.shop.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private MyUserDetailsService userDetailsService;
    private UserRepo userRepo;
    @Autowired
    public WebSecurityConfig(MyUserDetailsService userDetailsService, UserRepo userRepo) {
        this.userDetailsService = userDetailsService;
        this.userRepo=userRepo;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/").permitAll()
                .antMatchers("/gallery/*").hasAnyRole("ADMIN")
                .antMatchers("/images/new").hasAnyRole("ADMIN")
                .antMatchers("/images/delete/*").hasAnyRole("ADMIN")
                .antMatchers("/product/edit/*").hasAnyRole("ADMIN")
                .antMatchers("/product/save").hasAnyRole("ADMIN")
                .antMatchers("/product/new").hasAnyRole("ADMIN")
             //   .antMatchers("/product/*").hasAnyRole("USER","ADMIN")
                .antMatchers("/product/*").permitAll()
                .antMatchers("/product/**").permitAll()
                .antMatchers("/product/delete/*").hasAnyRole("ADMIN")
                .antMatchers("/panel").hasRole("ADMIN")
                .antMatchers("/product/update").hasRole("ADMIN")
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/user/save").permitAll()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .failureUrl("/login-error.html")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and().headers().frameOptions().disable()
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

