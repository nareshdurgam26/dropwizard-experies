package com.goldman.reststub;

import com.goldman.reststub.resources.PersonService;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class RestStubApp extends Application<RestStubConfig> {

    public static void main(String[] args) throws Exception {
        new RestStubApp().run(args);
    }

    @Override
    public void run(RestStubConfig config, Environment env) {
        final PersonService personService = new PersonService();
        env.jersey().register(personService);

        final RestStubCheck healthCheck = new RestStubCheck(config.getVersion());
        env.healthChecks().register("template", healthCheck);
        env.jersey().register(healthCheck);
    }
}