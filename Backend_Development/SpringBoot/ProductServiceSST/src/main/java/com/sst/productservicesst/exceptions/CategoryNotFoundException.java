package com.sst.productservicesst.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryNotFoundException extends RuntimeException {
    private String message;

    public CategoryNotFoundException(Long id, String message) {
        super(message);
    }
}
