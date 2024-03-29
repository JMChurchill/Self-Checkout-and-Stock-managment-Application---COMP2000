package model;

import java.util.ArrayList;

public class ScannedProducts {
    private static final ArrayList<ScannedProduct> allScanned = new ArrayList<>();

    public ArrayList<ScannedProduct> getAll(){
        return allScanned;
    }

    public void addProduct(ScannedProduct newScan){
        allScanned.add(newScan);
    }

    public void remove(ScannedProduct oldScan){
        allScanned.remove(oldScan);
    }

    public static double getTotalPrice(){
        double totalPrice = 0;
        if (allScanned.isEmpty()){
            totalPrice = 0;
        }else{
            for (ScannedProduct product:allScanned) {
                totalPrice = totalPrice + (product.getPrice() * product.getQuantityScanned());
            }
        }
        return totalPrice;
    }

    public ScannedProduct getProductAt(int index){
        if (index >= allScanned.size()){
            return null;
        }
        return allScanned.get(index);
    }

}
