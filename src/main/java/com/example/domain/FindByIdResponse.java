package com.example.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class FindByIdResponse {

    @Autowired
    private Collection<Item> item;
    private Status status;

    public FindByIdResponse(Collection<Item> item, Status status) {
        this.item = item;
        this.status = status;
    }

    public FindByIdResponse() {
    }

    public Collection<Item> getItem() {
        return item;
    }

    public Status getStatus() {
        return status;
    }
}
