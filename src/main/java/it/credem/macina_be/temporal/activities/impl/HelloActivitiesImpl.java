package it.credem.macina_be.temporal.activities.impl;

import it.credem.macina_be.temporal.activities.HelloActivities;
import org.springframework.stereotype.Component;

@Component
public class HelloActivitiesImpl implements HelloActivities {

    private int attempt = 0;

    @Override
    public String composeGreeting(String name) {
        attempt++;
        if ((name.equalsIgnoreCase("err")) && (attempt < 3)) {
            throw new RuntimeException("Simulated error");
        }
        return "Ciao " + "\"" + name + "\"" + " 👋";
    }
}