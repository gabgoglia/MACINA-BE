package it.credem.macina_be.temporal.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface AdvancedActivities {

    @ActivityMethod
    String validateInput(String name);

    @ActivityMethod
    String enrichData(String name);

    @ActivityMethod
    void saveToDatabase(String enriched);

    @ActivityMethod
    void sendNotification(String enriched);
}