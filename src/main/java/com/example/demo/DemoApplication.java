package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class DemoApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) throws UnknownHostException {


        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        Environment env = context.getEnvironment();

        LOGGER.info("\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t"
                        + "Local: \t\thttp://127.0.0.1:{}\n\t"
                        + "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name") != null ? env.getProperty("spring.application.name") : "DemoApplication",
                env.getProperty("server.port") != null ? env.getProperty("server.port") : "80",
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port") != null ? env.getProperty("server.port") : "80");
    }
}
