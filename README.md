# Client Service

This service is a simple Quarkus REST service that calls the resource service.

## Configuration

Before running the service, you need to configure the Keycloak connection in `src/main/resources/application.properties`.

- `quarkus.oidc-client.auth-server-url`: The URL of your Keycloak server.
- `quarkus.oidc-client.client-id`: The client ID for this service in Keycloak.
- `quarkus.oidc-client.credentials.secret`: The client secret for this service in Keycloak.
- `org.acme.ResourceServiceClient/mp-rest/url`: The URL of the resource service.

You also need to update the `cloudbuild.yaml` file with your GCP project details:

- `your-gcp-project-id`: Your GCP project ID.
- `your-artifact-registry-repo`: The name of your Artifact Registry repository.

## Running the service

To run the service locally, you can use the following command:

```bash
mvn quarkus:dev
```

## Deployment

To deploy the service to Google Cloud Run, you can use the following command:

```bash
gcloud builds submit --config cloudbuild.yaml .
```
