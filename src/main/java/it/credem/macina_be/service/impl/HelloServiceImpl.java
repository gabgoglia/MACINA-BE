package it.credem.macina_be.service.impl;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import it.credem.macina_be.config.WorkerConfig;
import it.credem.macina_be.service.HelloService;
import it.credem.macina_be.temporal.workflow.HelloWorkflow;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HelloServiceImpl implements HelloService {
    private final WorkflowClient client;

    public HelloServiceImpl(WorkflowClient client) { this.client = client; }

    public String startHello(String name) {
        String workflowId = "hello-" + UUID.randomUUID();
        HelloWorkflow wf = client.newWorkflowStub(
                HelloWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setTaskQueue(WorkerConfig.HELLO_TQ)
                        .setWorkflowId(workflowId)
                        .build()
        );
//        return WorkflowClient.execute(wf::sayHello, name)
        // Avvio asincrono
        WorkflowClient.start(wf::sayHello, name);
        // Poi attendo il risultato (bloccante) dal typed stub
        return WorkflowStub.fromTyped(wf).getResult(String.class);

    }
}