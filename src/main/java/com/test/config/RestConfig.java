package com.test.config;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Rest config.
 */
@ApplicationPath("rest")
public class RestConfig extends ResourceConfig {

    public RestConfig() {
        packages("com.test.resources", "com.test.config", "com.test.data");
    }
}
