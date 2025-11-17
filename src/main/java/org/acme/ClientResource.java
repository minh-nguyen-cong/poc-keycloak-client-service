package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/client")
public class ClientResource {

    @Inject
    @RestClient
    ResourceServiceClient resourceServiceClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getResource() {
        return resourceServiceClient.getProtectedResource();
    }
}
