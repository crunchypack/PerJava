package com.store.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.store.entity.Item;

public class Store {

	public static void main(String[] args) {
		AddItems add = new AddItems();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome!");
		int choice = 0;
		do {
			menu();
			while(true) {
				try {
					choice = sc.nextInt();
					break;
				}catch(Exception e) {
					System.out.println("Please use a real number!");
					sc.nextLine();
					menu();
				}
			}
			
			
			sc.nextLine();
			switch(choice) {
			case 1:
				for(Item i : add.showItems()) {
					System.out.println(i.getId() + ". Name: " + i.getName() + "\n         Price: " + i.getPrice());
				}
				System.out.print("Choice (nr): ");
				add.addToOrder(sc.nextInt());
				sc.nextLine();
				break;
			case 2:
				double total = 0;
				for(Item i : add.getItems()) {
					total += i.getPrice();
					System.out.println(i.getId() + ". Name: " + i.getName() + "\n         Price: " + i.getPrice());
					System.out.println("Total: " + total);
				}
				break;
			case 3:
				System.out.println("This is your cart: ");
				double totalC = 0;
				for(Item i : add.getItems()) {
					totalC += i.getPrice();
					System.out.println(i.getId() + ". Name: " + i.getName() + "\n         Price: " + i.getPrice());
					System.out.println("Total: " + totalC);
				}
				System.out.print("Want to check out? (y/n): ");
				String exit = sc.nextLine();
				if(exit.contains("y")|| exit.contains("Y")) {
					add.createOrder(add.nrOrders()+1);
					List<Item> items = new ArrayList<Item>();
					add.setItems(items);
				}
				break;
			case 4:
				sc.close();
				add.end();
				System.out.println("Bye bye");
				break;
			case 99:
				System.out.println("Secret option 99! Add item to system");
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: (xx.xx) ");
				Double price = sc.nextDouble();
				sc.nextLine();
				Integer id = add.showItems().size() +1;
				Item i = new Item(id,name,price);
				add.addItem(i);
				break;				
			}
		}while(choice != 4);

	}
	public static void menu() {
		System.out.println("1. Add to cart");
		System.out.println("2. Show cart");
		System.out.println("3. Check out");
		System.out.println("4. Quit");
	}

}
