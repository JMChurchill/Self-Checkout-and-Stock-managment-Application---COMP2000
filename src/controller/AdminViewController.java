package controller;

import model.Product;

import javax.swing.*;

public class AdminViewController {
    public static boolean orderProduct(String productOrdering, int numOrdering, double price){
        boolean isFound = false;
        //edit file
        for (Product p:ProductDataManager.getAllProducts()) {
            if (p.getBarcode().equals(productOrdering)){
                int stock = numOrdering + p.getStock();
                p.setStock(stock);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            ProductDataManager pData = new ProductDataManager();
            pData.save();
//                JOptionPane.showMessageDialog(null,"Product updated");
//                rightAdCl.show(rightAdPanel,"1");
        }else{
            JOptionPane.showMessageDialog(null,"Product not found");
        }
        return isFound;
    }
    public static boolean saveEditChanges(String name, String barcode, int stock, double price){
        boolean isFound = false;
        //loop through array and search for matching barcode
        for (Product p:ProductDataManager.getAllProducts()) {
            if (p.getBarcode().equals(barcode)){
                //edit product details with edited values
                p.setName(name);
                p.setStock(stock);
                p.setPrice(price);
                isFound = true;
                break;
            }
        }
        if (isFound){
            //save product array to text file
            ProductDataManager pdata = new ProductDataManager();
            pdata.save();
            JOptionPane.showMessageDialog(null,"Product Edited");

        }else{
            //display error message
            JOptionPane.showMessageDialog(null,"The product you were trying to edit was not found");
        }
        //todo refresh rightAdPanel

        return isFound;

    }

    public static void refreshAdminView(){

    }
}
