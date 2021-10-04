package br.com.srconsultoria.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope
@Configuration
public class AppConfig implements CommandLineRunner{
	
	// Para ler o application.properties do git
	
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		
		JwtAccessTokenConverter tokenConverter= new JwtAccessTokenConverter ();
//		tokenConverter.setSigningKey(jwtSecret);
		tokenConverter.setSigningKey("MY-SECRET-KEY");
		

		return tokenConverter;
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
	
		return new JwtTokenStore(accessTokenConverter());
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("JWTSECRET = "+ jwtSecret);
		
	}

}
