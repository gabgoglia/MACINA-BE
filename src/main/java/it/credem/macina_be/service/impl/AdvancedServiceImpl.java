package it.credem.macina_be.service.impl;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import it.credem.macina_be.model.dto.AdvancedRequest;
import it.credem.macina_be.model.dto.AdvancedResponse;
import it.credem.macina_be.service.AdvancedService;
import it.credem.macina_be.temporal.workflow.AdvancedWorkflow;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdvancedServiceImpl implements AdvancedService {

    private final WorkflowClient client;

    public AdvancedServiceImpl(WorkflowClient client) {
        this.client = client;
    }

    public AdvancedResponse process(AdvancedRequest req) {
        // Esempio di regola di dominio "locale" (valida prima di pagare il costo del workflow)
        if (req.name() == null || req.name().isBlank()) {
            return AdvancedResponse.rejected("Name is mandatory");
        }

        // Avvio WORKFLOW (sincrono): attende il risultato
        var options = WorkflowOptions.newBuilder()
                .setTaskQueue("ADVANCED_TQ")
                .setWorkflowId("ADV-" + UUID.randomUUID())
                .build();

        var wf = client.newWorkflowStub(AdvancedWorkflow.class, options);

        try {
            String result = wf.processUser(req.name());
            return AdvancedResponse.ok(result);
        } catch (Exception e) {
            // In casi reali: mappa eccezioni specifiche (es. ActivityFailure) a motivazioni business
            return AdvancedResponse.failed("Workflow failed: " + e.getMessage());
        }

        /*
        // Variante ASINCRONA (se vuoi restituire subito l'ID):
        WorkflowExecution exec = WorkflowClient.start(wf::processUser, req.name());
        return AdvancedResponse.ok("Started: " + exec.getWorkflowId() + "/" + exec.getRunId());
        */
    }
}
