package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
    private HashMap<String,Item> itemCollection;
   
    TheSystem() {
        itemCollection = new HashMap<>();
       if(getClass().getSimpleName().equals("AppSystem")) {
           try(Scanner in = new Scanner(new File("resources//sample.txt"));){ // Try catch for reading the file
               while(in.hasNextLine()) { // Each line in the file
                   String[] itemInfo = in.nextLine().split("\s "); // Double space delimiter
                   double price = Double.parseDouble(itemInfo[2]); // Parse price
                   int quantity = Integer.parseInt(itemInfo[3]); // parse quantity
                   // Add the item to the collection
                   itemCollection.put(itemInfo[0], new Item(itemInfo[0],itemInfo[1],price,quantity));
               }
               
           }catch(FileNotFoundException e) {
               System.out.println("File not found!");
               e.getStackTrace();
           }
       }
    }
    
    public HashMap<String, Item> getItemCollection(){
        // Your code here
        return itemCollection;
    }
    public void setItemCollection(HashMap<String,Item> item) {
        this.itemCollection = item;
    }
    /**
     * Checks if there is enough available items
     * @param item the item to check availability
     * @return true or false depending on if there is available items
     */
    public Boolean checkAvailability(Item item) {
        if(item.getQuantity() >= item.getAvailableQuantity()) {
            System.out.println("System is unable to add " + item.getItemName() + " to the cart. System only has "+ item.getAvailableQuantity() + " " + item.getItemName()+ "s");
            return false;
        }
        return true;
         
    }
    /**
     * Adds an item to the collection
     * @param item the specific item to be added
     * @return true or false depending on if the item is successfully added
     */
    public Boolean add(Item item) {
        if(item != null) { // Check for null
            if(itemCollection.containsKey(item.getItemName())&& checkAvailability(item)) { // Check if its in the collection and is available
                int qu = item.getQuantity() + 1; // Increase quantity +1
                item.setQuantity(qu);
                itemCollection.replace(item.getItemName(), item); // Update HashMap
                return true;
            }else if(!itemCollection.containsKey(item.getItemName())) { // if it doesn't exist in the collection
                item.setQuantity(1);
                itemCollection.put(item.getItemName(), item); // add to collection
                return true;
            }
            return false;
            
        }            
        return false;
    }
    
    /**
     * Removes item from collection
     * @param itemName
     * @return The removed item or null if it doesn't exists
     */
    public Item remove(String itemName) {
        if(itemCollection.containsKey(itemName)) { // Check if item exists in collection
            Item rem = itemCollection.get(itemName); // Create an reference to the item
            int quant = rem.getQuantity(); 
            rem.setAvailableQuantity(rem.getAvailableQuantity()+quant); // reseting the available quantaty 
            itemCollection.remove(itemName); // Removing item from collection
            return rem; // returning item removed
        }
        return null;
    }

    public abstract void display();
}
