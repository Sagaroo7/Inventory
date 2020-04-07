package com.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "Item_Info")
public class ItemInfo {

    @Id
    @Column(name = "Item_Info_Id")
    private int itemInfoId;

    @Column(name = "Manufactured_By")
    private String manufacturedBy;

    @Column(name = "Description")
    private String description;

   /* @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Item_Id", nullable = false)
    private Item item;*/

    public ItemInfo(int itemInfoId, String manufacturedBy, String description) {
        this.itemInfoId = itemInfoId;
        this.manufacturedBy = manufacturedBy;
        this.description = description;
    }

    public ItemInfo() {
    }

    public int getItemInfoId() {
        return itemInfoId;
    }

    public void setItemInfoId(int itemInfoId) {
        this.itemInfoId = itemInfoId;
    }

    public String getManufacturedBy() {
        return manufacturedBy;
    }

    public void setManufacturedBy(String manufacturedBy) {
        this.manufacturedBy = manufacturedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
