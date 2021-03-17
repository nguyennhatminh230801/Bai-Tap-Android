package com.example.btvntuan4;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Parcelable, Serializable, Comparable<Product>{
    int ImageItem;
    String nameItem;
    int Price;
    int Amount;
    int IncreaseItem;
    int DecreaseItem;

    public Product() {
    }

    public Product(int imageItem, String nameItem, int price, int amount, int increaseItem, int decreaseItem) {
        ImageItem = imageItem;
        this.nameItem = nameItem;
        Price = price;
        Amount = amount;
        IncreaseItem = increaseItem;
        DecreaseItem = decreaseItem;
    }

    public int getImageItem() {
        return ImageItem;
    }

    public void setImageItem(int imageItem) {
        ImageItem = imageItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getIncreaseItem() {
        return IncreaseItem;
    }

    public void setIncreaseItem(int increaseItem) {
        IncreaseItem = increaseItem;
    }

    public int getDecreaseItem() {
        return DecreaseItem;
    }

    public void setDecreaseItem(int decreaseItem) {
        DecreaseItem = decreaseItem;
    }

    protected Product(Parcel in) {
        ImageItem = in.readInt();
        nameItem = in.readString();
        Price = in.readInt();
        Amount = in.readInt();
        IncreaseItem = in.readInt();
        DecreaseItem = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ImageItem);
        dest.writeString(nameItem);
        dest.writeInt(Price);
        dest.writeInt(Amount);
        dest.writeInt(IncreaseItem);
        dest.writeInt(DecreaseItem);
    }

    @Override
    public int compareTo(Product object) {
        String str1 = this.getNameItem().toLowerCase().trim();
        String str2 = object.getNameItem().toLowerCase().trim();
        return str1.compareTo(str2);
    }
}
