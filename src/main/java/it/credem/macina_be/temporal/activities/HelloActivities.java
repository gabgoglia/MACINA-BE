package it.credem.macina_be.temporal.activities;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface HelloActivities {
    String composeGreeting(String name);
}