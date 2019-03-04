package com.thesundaylunatics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.google.common.collect.ImmutableList;


@Configuration("kieServerSecurity")
@EnableWebSecurity
public class DefaultWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/rest/*").authenticated()
        .antMatchers("/rest2/*").authenticated()
        .and()
        .httpBasic();
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(ImmutableList.of("*"));
        configuration.setAllowedMethods(ImmutableList.of("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication().withUser("cust1").password("cust1").roles("customer");
    	auth.inMemoryAuthentication().withUser("cust2").password("cust2").roles("customer");
    	auth.inMemoryAuthentication().withUser("cust3").password("cust3").roles("customer");
    	auth.inMemoryAuthentication().withUser("cust4").password("cust4").roles("customer");
    	auth.inMemoryAuthentication().withUser("s1").password("s1").roles("sales");
    	auth.inMemoryAuthentication().withUser("s2").password("s2").roles("sales");
    	auth.inMemoryAuthentication().withUser("s3").password("s3").roles("sales");
    	auth.inMemoryAuthentication().withUser("s4").password("s4").roles("sales");
    	auth.inMemoryAuthentication().withUser("acc1").password("acc1").roles("accounts");
    	auth.inMemoryAuthentication().withUser("acc2").password("acc2").roles("accounts");
    	auth.inMemoryAuthentication().withUser("acc3").password("acc3").roles("accounts");
    	auth.inMemoryAuthentication().withUser("acc4").password("acc4").roles("accounts");
    	auth.inMemoryAuthentication().withUser("wh1").password("wh1").roles("warehouse");
    	auth.inMemoryAuthentication().withUser("wh2").password("wh2").roles("warehouse");
    	auth.inMemoryAuthentication().withUser("wh3").password("wh3").roles("warehouse");
    	auth.inMemoryAuthentication().withUser("wh4").password("wh4").roles("warehouse");
    	auth.inMemoryAuthentication().withUser("shp1").password("shp1").roles("shipping");
    	auth.inMemoryAuthentication().withUser("shp2").password("shp2").roles("shipping");
    	auth.inMemoryAuthentication().withUser("shp3").password("shp3").roles("shipping");
    	auth.inMemoryAuthentication().withUser("shp4").password("shp4").roles("shipping");
    	auth.inMemoryAuthentication().withUser("sup1").password("sup1").roles("supplier");
    	auth.inMemoryAuthentication().withUser("sup2").password("sup2").roles("supplier");
    	auth.inMemoryAuthentication().withUser("sup3").password("sup3").roles("supplier");
    	auth.inMemoryAuthentication().withUser("sup4").password("sup4").roles("supplier");
    	
        auth.inMemoryAuthentication().withUser("user").password("user").roles("kie-server");
        auth.inMemoryAuthentication().withUser("wbadmin").password("wbadmin").roles("admin");
        auth.inMemoryAuthentication().withUser("kieserver").password("kieserver1!").roles("kie-server");
        
    }
}