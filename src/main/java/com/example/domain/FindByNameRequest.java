package com.example.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class FindByNameRequest {

    @Valid
    @NotNull(message = "Item name cannot be empty.")
    private String name;

    public FindByNameRequest(String name) {
        this.name = name;
    }

    public FindByNameRequest() {
    }

    public String getName() {
        return name;
    }
}
