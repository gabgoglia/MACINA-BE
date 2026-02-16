package it.credem.macina_be.config;

import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import it.credem.macina_be.temporal.activities.impl.HelloActivitiesImpl;
import it.credem.macina_be.temporal.workflow.impl.HelloWorkflowImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("worker")
public class WorkerConfig {

    public static final String HELLO_TQ = "HELLO_TQ";

    @Bean
    public WorkerFactory workerFactory(io.temporal.client.WorkflowClient client) {
        return WorkerFactory.newInstance(client);
    }

    @Bean
    public Worker helloWorker(WorkerFactory factory,
                              HelloActivitiesImpl helloActivities) {

        Worker worker = factory.newWorker(HELLO_TQ);

        worker.registerWorkflowImplementationTypes(HelloWorkflowImpl.class);
        worker.registerActivitiesImplementations(helloActivities);

        factory.start();
        return worker;
    }
}
