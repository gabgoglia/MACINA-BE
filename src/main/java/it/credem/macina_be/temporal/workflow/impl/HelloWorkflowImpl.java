package it.credem.macina_be.temporal.workflow.impl;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import it.credem.macina_be.temporal.activities.HelloActivities;
import it.credem.macina_be.temporal.workflow.HelloWorkflow;

import java.time.Duration;

public class HelloWorkflowImpl implements HelloWorkflow {

    private final HelloActivities activities = Workflow.newActivityStub(
            HelloActivities.class,
            ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofSeconds(10))
                    .build()
    );

    @Override
    public String sayHello(String name) {
        return activities.composeGreeting(name);
    }
}