package com.example;
import java.util.HashMap;

public class CartSystem extends TheSystem {
    private double subTotal, total;
    private static final double TAX = 0.05;
    CartSystem() {
    }

    @Override
    public void display() {
        System.out.println("Cart:");
        HashMap<String,Item> items = getItemCollection(); // Get the items
        subTotal = 0;
        System.out.printf("%-20s %-20s %-10s %-10s %-10s%n","Name","Description","Price","Quantity","Sub Total");
        
        items.entrySet().forEach(entry->{ // For each entry in the hashmap get the value
            Item it = entry.getValue();
            double sub = it.getItemPrice()*it.getQuantity(); // Get subtotal for each item
            subTotal += sub; // Add to subtotal for all items
            // Print out items in correct format
            System.out.printf("%-20s %-20s %-10.2f %-10d %-10.2f %n", it.getItemName(),it.getItemDesc(),it.getItemPrice(),it.getQuantity(),sub);
        });
        double temp = subTotal *TAX; // Get the tax value
        total = temp + subTotal; // Total
        System.out.printf("%-20s %-20.2f%n%-20s %-20.2f%n%-20s %-20.2f%n","Pre-tax Total", subTotal,"Tax",temp,"Total",total);
    }
}
