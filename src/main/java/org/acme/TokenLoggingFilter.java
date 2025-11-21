package org.acme;

import java.io.IOException;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class TokenLoggingFilter implements ClientRequestFilter {

    private static final Logger LOG = Logger.getLogger(TokenLoggingFilter.class);

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring("Bearer ".length());
            LOG.infof("Outgoing Bearer Token: %s", token);
        } else {
            LOG.info("No Bearer token found in outgoing request.");
        }
    }
}
