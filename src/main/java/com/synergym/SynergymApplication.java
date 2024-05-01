package com.synergym;

import com.codahale.metrics.health.HealthCheck;
import com.synergym.resources.HelloWorldResource;
import com.synergym.resources.SynergymEntity;
import com.synergym.resources.SynergymEntityDAO;
import com.synergym.resources.SynergymResource;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

public class SynergymApplication extends Application<SynergymConfiguration> {

    public static void main(final String[] args) throws Exception {
        new SynergymApplication().run(args);
    }

    @Override
    public String getName() {
        return "Synergym";
    }

    @Override
    public void run(final SynergymConfiguration configuration,
            final Environment environment) {
        // register resource
        environment.jersey().register(new HelloWorldResource());

        SynergymEntityDAO synergymEntityDAO = new SynergymEntityDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new SynergymResource(synergymEntityDAO));

        // register healthchecks
        environment.healthChecks().register("synergym", new HealthCheck() {

            @Override
            protected Result check() throws Exception {
                return Result.healthy();
            }

        });
    }

    HibernateBundle<SynergymConfiguration> hibernateBundle = new HibernateBundle<SynergymConfiguration>(
            SynergymEntity.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(SynergymConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<SynergymConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

}
