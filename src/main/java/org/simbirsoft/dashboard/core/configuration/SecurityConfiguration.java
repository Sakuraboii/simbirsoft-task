package org.simbirsoft.dashboard.core.configuration;

import org.simbirsoft.dashboard.core.security.Roles;
import org.simbirsoft.dashboard.core.security.jwt.JwtConfigurer;
import org.simbirsoft.dashboard.core.security.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String AUTHENTICATED_ENDPOINT = "/unik/api/v1/**";
    private static final String LOGIN_ENDPOINT = "/unik/api/v1/account/sign-in";
    private static final String IMAGE_ENDPOINT = "/unik/api/v1/images";
    private static final String REGISTER_ENDPOINT = "/unik/api/v1/account/sign-up";
    private static final String ADMIN_ENDPOINT = "/unik/api/v1/admin/**";
    private static final String ACTIVATION_USER_ENDPOINT = "/unik/api/v1/users/activate/*";

    private UserDetailsService userDetailsService;

    private JwtTokenProvider jwtTokenProvider;

    private PasswordEncoder passwordEncoder;

    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    public SecurityConfiguration(UserDetailsService userDetailsService,
                                 JwtTokenProvider jwtTokenProvider,
                                 PasswordEncoder passwordEncoder,
                                 RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic().disable()
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(LOGIN_ENDPOINT, REGISTER_ENDPOINT, IMAGE_ENDPOINT).permitAll()
                .antMatchers(ADMIN_ENDPOINT).hasRole(Roles.ADMIN)
                .antMatchers(AUTHENTICATED_ENDPOINT).authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider, restAuthenticationEntryPoint));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
