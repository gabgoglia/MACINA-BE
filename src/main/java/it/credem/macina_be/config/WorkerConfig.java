package it.credem.macina_be.config;

import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import it.credem.macina_be.temporal.activities.impl.AdvancedActivitiesImpl;
import it.credem.macina_be.temporal.activities.impl.HelloActivitiesImpl;
import it.credem.macina_be.temporal.workflow.impl.AdvancedWorkflowImpl;
import it.credem.macina_be.temporal.workflow.impl.HelloWorkflowImpl;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("worker")
public class WorkerConfig {

    public static final String HELLO_TQ = "HELLO_TQ";
    public static final String ADVANCED_TQ = "ADVANCED_TQ";

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
        return worker;
    }

    @Bean
    public Worker advancedWorker(WorkerFactory factory,
                                 AdvancedActivitiesImpl activities) {
        Worker worker = factory.newWorker(ADVANCED_TQ);
        worker.registerWorkflowImplementationTypes(AdvancedWorkflowImpl.class);
        worker.registerActivitiesImplementations(activities);
        return worker;
    }

    @Bean
    public ApplicationRunner startFactory(WorkerFactory factory) {
        return args -> factory.start();
    }
}