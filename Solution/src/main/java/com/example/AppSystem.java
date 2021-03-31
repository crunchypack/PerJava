package com.example;
import java.util.HashMap;

public class AppSystem extends TheSystem {
    AppSystem() {
    }
        @Override
    public void display() {
        
        System.out.println("AppSystem Inventory:");
        // Get the items
        HashMap<String,Item> items = getItemCollection();
        // Format table head
        System.out.printf("%-20s %-20s %-10s %-10s%n","Name","Description","Price","Available Quantity");
        
        items.entrySet().forEach(entry->{ // for each entry in the hashmap get the value
            Item it = entry.getValue();
            // Print out items in correct format
            System.out.printf("%-20s %-20s %-10.2f %-10d%n", it.getItemName(),it.getItemDesc(),it.getItemPrice(),it.getAvailableQuantity());
        });
        
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        if(item != null) { // check for null
            if(getItemCollection().containsKey(item.getItemName())) { // check if item is already in hashmap by key
                System.out.println(item.getItemName() + " is already in the App System.");
                return false;
            }else {
                getItemCollection().put(item.getItemName(), item); // put in item 
                return true;
            }
        }else {
            return false;
        }
    }
   
     /**
     * Reduces available quantity 
     * @param  item_name the name of the item
     * @return Item found with item_name
     */
    public Item reduceAvailableQuantity(String item_name) {
        if(getItemCollection().containsKey(item_name)) {
            Item i = getItemCollection().get(item_name);
            i.setAvailableQuantity(i.getAvailableQuantity()-1);
            if(i.getAvailableQuantity() <= 0){
                getItemCollection().remove(item_name);
                return i;
            }
            getItemCollection().replace(item_name, i);
            return i;
        }else {
            return null;
        }
    }
}
