package com.example.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class FindByIdRequest {

    @Valid
    @NotNull(message = "Item ID cannot be null.")
    private int itemId;

    public FindByIdRequest(int itemId) {
        this.itemId = itemId;
    }

    public FindByIdRequest() {
    }

    public int getItemId() {
        return itemId;
    }
}
