package auto.rota.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Value("${security.security-realm}")
    private String securityRealm;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .stateless(false)
                .resourceId(resourceIds)
                .tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic().realmName(securityRealm)
                .and()
                .csrf().disable();
        http
                .requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers("/actuator/health", "/actuator/info", "/actuator/prometheus").permitAll()
                .antMatchers(HttpMethod.POST, "/users/").permitAll()
                .antMatchers("/actuator/**").hasAuthority("ADMIN")
                .antMatchers("/swagger-docs", "/swagger-ui.html", "/webjars/springfox-swagger-ui/**", "/swagger-resources", "/swagger-resources/**").permitAll()
                .anyRequest().authenticated();
    }
}
