package it.credem.macina_be.temporal.activities.impl;

import it.credem.macina_be.temporal.activities.HelloActivities;
import org.springframework.stereotype.Component;

@Component
public class HelloActivitiesImpl implements HelloActivities {
    @Override
    public String composeGreeting(String name) {
        return "Ciao " + name + " 👋";
    }
}