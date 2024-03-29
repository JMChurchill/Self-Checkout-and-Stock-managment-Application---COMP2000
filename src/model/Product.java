package model;

public class Product {


    private String Barcode;
    private String Name;
    private String Image;
    private double Price;
    private int Stock;
    private double WholesalePrice;

    public Product() {}

    public Product(String barcode,String name, String image, double price, int quantity, double wholesalePrice) {
        Barcode = barcode;
        Name = name;
        Image = image;
        Price = price;
        Stock = quantity;
        WholesalePrice = wholesalePrice;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        this.Barcode = barcode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public double getWholesalePrice() {
        return WholesalePrice;
    }

    public void setWholesalePrice(double wholesalePrice) {
        WholesalePrice = wholesalePrice;
    }

}
