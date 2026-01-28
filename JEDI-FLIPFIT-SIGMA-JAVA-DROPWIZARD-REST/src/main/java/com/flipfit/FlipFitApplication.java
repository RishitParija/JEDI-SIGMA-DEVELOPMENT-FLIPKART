package com.flipfit;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.flipfit.rest.AdminResource;
import com.flipfit.rest.CustomerResource;
import com.flipfit.rest.GymOwnerResource;
import com.flipfit.rest.UserResource;
import com.flipfit.rest.HealthCheckResource;
import com.flipfit.rest.BookingResource;
import com.flipfit.rest.NotificationResource;
import com.flipfit.rest.WaitlistResource;
import com.flipfit.rest.GymCentreResource;
import com.flipfit.rest.ScheduleResource;
import com.flipfit.rest.SlotResource;
import com.flipfit.rest.PaymentResource;
import com.flipfit.health.DatabaseHealthCheck;

public class FlipFitApplication extends Application<FlipFitConfiguration> {

    public static void main(final String[] args) throws Exception {
        new FlipFitApplication().run(args);
    }

    @Override
    public String getName() {
        return "FlipFit";
    }

    @Override
    public void initialize(final Bootstrap<FlipFitConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final FlipFitConfiguration configuration,
            final Environment environment) {
        // Initialize data/database
        com.flipfit.constants.SQLConnectorConstants.loadMockData();

        // Register healthchecks
        environment.healthChecks().register("database", new DatabaseHealthCheck());

        // Register resources
        environment.jersey().register(new HealthCheckResource());
        environment.jersey().register(new AdminResource());
        environment.jersey().register(new CustomerResource());
        environment.jersey().register(new GymOwnerResource());
        environment.jersey().register(new UserResource());
        environment.jersey().register(new BookingResource());
        environment.jersey().register(new NotificationResource());
        environment.jersey().register(new WaitlistResource());
        environment.jersey().register(new GymCentreResource());
        environment.jersey().register(new ScheduleResource());
        environment.jersey().register(new SlotResource());
        environment.jersey().register(new PaymentResource());
    }

}
