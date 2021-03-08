package com.example.mission14;

import android.widget.ImageView;
import android.widget.TextView;

public class ItemList {
    int itemImage;
    String itemName;
    String itemPrice;
    String itemExam;

    public ItemList(int itemImage, String itemName, String itemPrice, String itemExam) {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemExam = itemExam;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemExam() {
        return itemExam;
    }

    public void setItemExam(String itemExam) {
        this.itemExam = itemExam;
    }
}
