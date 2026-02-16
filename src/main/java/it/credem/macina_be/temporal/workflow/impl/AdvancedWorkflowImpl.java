package it.credem.macina_be.temporal.workflow.impl;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;
import it.credem.macina_be.temporal.activities.AdvancedActivities;
import it.credem.macina_be.temporal.workflow.AdvancedWorkflow;

import java.time.Duration;

public class AdvancedWorkflowImpl implements AdvancedWorkflow {

    private final AdvancedActivities activities =
            Workflow.newActivityStub(
                    AdvancedActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(5))
                            .setRetryOptions(
                                    RetryOptions.newBuilder()
                                            .setInitialInterval(Duration.ofSeconds(1))
                                            .setBackoffCoefficient(2)
                                            .setMaximumAttempts(3)
                                            .build()
                            )
                            .build()
            );


    @Override
    public String processUser(String name) {

        // 1) VALIDATION
        String validName = activities.validateInput(name);

        if (validName.length() < 3) {
            return "Rejected: name too short";
        }

        // 2) ENRICHMENT
        String enriched = activities.enrichData(validName);

        // 3) SAVE
        activities.saveToDatabase(enriched);

        // 4) SEND NOTIFICATION
        activities.sendNotification(enriched);

        // 5) WAIT 10 SECONDS (NON BLOCCA THREAD)
        Workflow.sleep(Duration.ofSeconds(10));

        // 6) RESULT
        return "Workflow completed with: " + enriched;
    }
}
