package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.client.filter.OidcClientFilter;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;

@RegisterRestClient(configKey = "data")
@RegisterProvider(TokenLoggingFilter.class)
@OidcClientFilter("data")
@Path("/api/protected")
public interface ResourceServiceClient {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String getProtectedResource();
}
