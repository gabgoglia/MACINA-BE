package it.credem.macina_be.temporal.activities.impl;

import it.credem.macina_be.temporal.activities.AdvancedActivities;
import org.springframework.stereotype.Component;

@Component
public class AdvancedActivitiesImpl implements AdvancedActivities {

    @Override
    public String validateInput(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }
        System.out.println("[Activity] Valid name: " + name);
        return name.trim();
    }

    @Override
    public String enrichData(String name) {
        System.out.println("[Activity] Enriching data for: " + name);
        return name.toUpperCase() + "_ENRICHED";
    }

    @Override
    public void saveToDatabase(String enriched) {
        System.out.println("[Activity] Saving into database: " + enriched);
    }

    @Override
    public void sendNotification(String enriched) {
        System.out.println("[Activity] Sending notification for: " + enriched);
    }
}
