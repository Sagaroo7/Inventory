package com.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Item_Id", unique = true, nullable = false)
    private int itemId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private float price;

    @OneToOne(fetch = FetchType.EAGER)
    @Column(name = "Item_Info")
    private ItemInfo itemInfo;

    public Item(int itemId, String name, float price, ItemInfo itemInfo) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.itemInfo = itemInfo;
    }

    public Item() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(ItemInfo itemInfo) {
        this.itemInfo = itemInfo;
    }
}
