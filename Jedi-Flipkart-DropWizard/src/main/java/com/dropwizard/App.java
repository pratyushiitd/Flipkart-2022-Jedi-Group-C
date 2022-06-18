package com.dropwizard;

//import com.dropwizard.rest.EmployeeRestController;
//import com.dropwizard.rest.HelloRestController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.dropwizard.rest.ProfessorRestController;
import com.dropwizard.rest.AdminRestController;
import com.dropwizard.rest.StudentRestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");

        e.jersey().register(new ProfessorRestController(e.getValidator()));
        e.jersey().register(new StudentRestController(e.getValidator()));
//        e.jersey().register(new AdminRestController(e.getValidator()));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}