package it.credem.macina_be.temporal.workflow;


import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface AdvancedWorkflow {

    @WorkflowMethod
    String processUser(String name);
}
