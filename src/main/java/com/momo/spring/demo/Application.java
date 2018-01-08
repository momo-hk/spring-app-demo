package com.momo.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
@EnableWebSecurity
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Configuration
	public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

		@Bean
		public UserDetailsService userDetailsService() {
			InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
			manager.createUser(
					User.withDefaultPasswordEncoder().username("admin").password("pwd").roles("ADMIN").build());
			return manager;
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.csrf()
					.disable()
				.authorizeRequests()
					.antMatchers("/webjars/**").permitAll()
				.anyRequest()
					.authenticated()
				.and()
				.formLogin()
					.loginPage("/login").permitAll()
					.defaultSuccessUrl("/students/pagination", true)
				.and()
				.logout()
					.deleteCookies("remember-me")
					.permitAll()
				.and()
				.rememberMe()
					.tokenValiditySeconds(180);
		}
	}
}
