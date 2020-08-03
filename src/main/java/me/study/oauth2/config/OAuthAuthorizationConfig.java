package me.study.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class OAuthAuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("testClientId").secret("testSecret")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .authorities("USER")
                .scopes("read", "write")
                .redirectUris("http://localhost:8081/oauth2/callback")
                .accessTokenValiditySeconds(30000);
    }
}
