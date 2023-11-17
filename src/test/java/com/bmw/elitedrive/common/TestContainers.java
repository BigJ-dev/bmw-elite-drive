package com.bmw.elitedrive.common;


import lombok.SneakyThrows;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@ActiveProfiles("test")
@ContextConfiguration(initializers = {TestContainers.Initializer.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class TestContainers {
    static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(
            DockerImageName.parse("public.ecr.aws/docker/library/postgres:15")
                    .asCompatibleSubstituteFor("postgres")).withDatabaseName("db")
            .withUsername("user")
            .withPassword("passw0rd")
            .withConnectTimeoutSeconds(10);

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @SneakyThrows
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of("spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                            "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                            "spring.datasource.password=" + postgreSQLContainer.getPassword())
                    .applyTo(configurableApplicationContext.getEnvironment());

        }
    }

    static {
        postgreSQLContainer.start();
    }
}
