package org.example.generic.controller;

import org.example.generic.controller.util.DefaultProfileUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * Define Application.
 *
 * @author hungp
 */
@SpringBootApplication
public class Application {

    private final Environment env;

    public Application(Environment env) {
        this.env = env;
    }

    /**
     * Run application.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
    }
}
