package com.example.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class FindByNameResponse {

    @Autowired
    private Collection<Item> items;
    private Status status;

    public FindByNameResponse(Collection<Item> items, Status status) {
        this.items = items;
        this.status = status;
    }

    public FindByNameResponse() {
    }

    public Collection<Item> getItems() {
        return items;
    }

    public Status getStatus() {
        return status;
    }
}
