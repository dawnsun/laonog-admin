package auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class AuthBootstrap implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(AuthBootstrap.class, args);
    }

}
