package me.study.oauth2.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/api/**").hasAuthority("ROLE_API");
    }

    @Bean
    public ResourceServerTokenServices resourceServerTokenServices() {

        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setClientId("clientAuth");
        remoteTokenServices.setClientSecret("123456");
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8100/oauth/check_token");
        return remoteTokenServices;
    }
}
