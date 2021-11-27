package INT222.Project.Security;

import INT222.Project.Models.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    AuthenEntryPointJwt authenEntryPointJwt;

    @Bean
    public AuthenTokenFilter authenticationJwtTokenFilter(){
        return new AuthenTokenFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Authority Admin
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/listuser").hasAuthority(String.valueOf(ERole.Admin));
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/user/delete/{userId}").hasAuthority(String.valueOf(ERole.Admin));
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/brand/add").hasAuthority(String.valueOf(ERole.Admin));
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/brand/delete/{brandId}").hasAuthority(String.valueOf(ERole.Admin));
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/color/add").hasAuthority(String.valueOf(ERole.Admin));
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/color/delete/{colorId}").hasAuthority(String.valueOf(ERole.Admin));

        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authenEntryPointJwt).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/auth/**", "/image/*", "/product","/product/**", "/color/**", "/brand/**").permitAll()
                .anyRequest().authenticated();


        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);


    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

