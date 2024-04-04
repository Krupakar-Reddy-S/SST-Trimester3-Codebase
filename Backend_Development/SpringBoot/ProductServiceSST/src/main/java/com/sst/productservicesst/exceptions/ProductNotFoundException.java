package com.sst.productservicesst.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends RuntimeException {
    private Long id;
    public String message;

    public ProductNotFoundException(Long id, String message) {
        this.id = id;
        this.message = message;
    }
}
