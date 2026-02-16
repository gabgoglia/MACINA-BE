package it.credem.macina_be.config;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalClientConfig {

    @Bean
    public WorkflowServiceStubs workflowService(
            @Value("${temporal.address:127.0.0.1:7233}") String address) {
        return WorkflowServiceStubs.newServiceStubs(
                WorkflowServiceStubsOptions.newBuilder()
                        .setTarget(address)
                        .build());
    }

    @Bean
    public WorkflowClient workflowClient(
            WorkflowServiceStubs service,
            @Value("${temporal.namespace:default}") String namespace) {
        return WorkflowClient.newInstance(
                service,
                WorkflowClientOptions.newBuilder()
                        .setNamespace(namespace)
                        .build());
    }
}
