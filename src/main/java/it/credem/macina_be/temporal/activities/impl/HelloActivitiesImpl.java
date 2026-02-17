package it.credem.macina_be.temporal.activities.impl;

import it.credem.macina_be.temporal.activities.HelloActivities;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class HelloActivitiesImpl implements HelloActivities {

    private int attempt = 0;

    @Override
    public String composeGreeting(String name) {
        attempt++;
        if ((name.equalsIgnoreCase("err")) && (attempt < 3)) {
            throw new RuntimeException("Simulated error");
        }
        log.info("[HelloActivities] executed - name={}", name);
        return "Ciao " + "\"" + name + "\"" + " 👋";
    }
}