package center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 启动一个服务注册中心提供给其他应用进行对话
 * 服务注册中心启动 Eureka
 */
@EnableEurekaServer
@SpringBootApplication
public class CenterBootstrapTest {
    public static void main(String[] args) {
        SpringApplication.run(CenterBootstrapTest.class, args);
    }
}
