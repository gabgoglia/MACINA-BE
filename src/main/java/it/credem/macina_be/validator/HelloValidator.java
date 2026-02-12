package it.credem.macina_be.validator;

import it.credem.macina_be.model.exception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class HelloValidator {

    public void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new BusinessException("Name cannot be empty");
        }
    }
}
