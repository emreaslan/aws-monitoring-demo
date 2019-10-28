package com.example.awsdemo;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:aws.properties")
@ContextConfiguration(initializers = {AwsDemoApplicationTests.Initializer.class})
public class AwsDemoApplicationTests {

    @ClassRule
    public static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres")
            .withDatabaseName("awsTestDb")
            .withUsername("testUser")
            .withPassword("testPassword");

    static {
        postgres.start();
    }

    @Test
    public void contextLoads() {
    }

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgres.getJdbcUrl(),
                    "spring.datasource.username=" + postgres.getUsername(),
                    "spring.datasource.password=" + postgres.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());

        }
    }
}