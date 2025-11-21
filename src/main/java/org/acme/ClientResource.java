package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/client")
public class ClientResource {

    private static final Logger LOG = Logger.getLogger(ClientResource.class);

    @Inject
    @RestClient
    ResourceServiceClient resourceServiceClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getResource() {
        LOG.info("Minh test - getResource()");
        return resourceServiceClient.getProtectedResource();
    }
}
