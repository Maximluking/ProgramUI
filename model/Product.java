package model;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 123L;
    private long productId;
    private String productName;
    private int productNumber;
    private int productValue;
    private int productWeight;
    private int productVolume;

    public Product(long productId, String productName, int productNumber, int productValue, int productWeight, int productVolume) {
        this.productId = productId;
        this.productName = productName;
        this.productNumber = productNumber;
        this.productValue = productValue;
        this.productWeight = productWeight;
        this.productVolume = productVolume;
    }

    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public int getProductValue() {
        return productValue;
    }

    public void setProductValue(int productValue) {
        this.productValue = productValue;
    }

    public int getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(int productWeight) {
        this.productWeight = productWeight;
    }

    public int getProductVolume() {
        return productVolume;
    }

    public void setProductVolume(int productVolume) {
        this.productVolume = productVolume;
    }

    @Override
    public String toString(){
        return "ID: " + productId + ", "
                + "Name: " + productName + ", "
                + "Number: " + productNumber + ", "
                + "Value: " + productValue + ", "
                + "Weight: " + productWeight + ", "
                + "Volume: " + productVolume + "\r\n";
    }
}
