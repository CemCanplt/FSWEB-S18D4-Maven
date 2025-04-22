package com.workintech.s18d1.util;

import com.workintech.s18d1.exceptions.BurgerErrorException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void checkName(String name) {
        if (name == null || name.isEmpty()) {
            throw new BurgerErrorException("Burger ya null ya da Empty durumda", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
