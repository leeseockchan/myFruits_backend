package kr.co.cofile.fruitshop.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // 콘솔 창 error 메세지를 띄워준다.
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("security config ...");

        http
                .formLogin(formLogin -> formLogin
                        .loginPage("/auth/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                // loginPage - 로그인 페이지 url
                // defaultSuccessUrl - 로그인 성공 시 이동한 url
                // permitAll - 로그인 페이지 접근을 모든 사용자에게 허용
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/home", "/auth/signup").permitAll()
                        .requestMatchers("/admin","/admin/users", "/admin/user/*/roles", "/admin/user/*/role/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                // ("/admin/login").permitAll() - 인증 없이 접근 가능
                // ("/admin/user/{id}").hasRole("ADMIN") - id 가 ADMIN 과 일치해야만 접근 가능
                // ("/admin/**") - ("/admin/**")=admin 하위폴더,파일 전부 다 해당 */
                // .hasAnyRole("ADMIN", "MANAGER") - ADMIN 또는 MANAGER 역할이 있어야 접근이 가능
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                );
        // logout 성공 시 /admin 페이지로 리디렉트
        return http.build();
    }
    // API 서버용 시큐리티 설정 (JSON 기반)
    @Bean
    @Order(2)
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
        log.info("API security config...");

        http
                .securityMatcher("/api/**")  // API 요청에만 적용
                .csrf(AbstractHttpConfigurer::disable)
                // API 서버는 세션을 사용하지 않기에 disable 비활성화
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT 또는 Stateless 환경
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/public/**").permitAll() // 공개 API
                        .requestMatchers("/api/v1/auth/login", "/api/v1/auth/signup").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}