package com.example.domain;

import java.util.Collection;

public class ListAllItemsResponse {

    private Collection<Item> items;
    private Status status;

    public ListAllItemsResponse(Collection<Item> items, Status status) {
        this.items = items;
        this.status = status;
    }

    public ListAllItemsResponse() {
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
