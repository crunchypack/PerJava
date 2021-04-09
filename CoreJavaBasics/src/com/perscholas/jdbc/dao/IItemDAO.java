package com.perscholas.jdbc.dao;

import java.util.List;

import com.perscholas.jdbc.Item;

public interface IItemDAO {
	public static final String GET_ALL_ITEMS = "SELECT * FROM items";
	public static final String ADD_ITEM ="INSERT INTO items VALUES (?,?,?)";
	public static final String REMOVE_ITEM_BY_ID = "DELETE FROM items WHERE id = ?";
	
	public List<Item> getAllItems();
	public void addItem(Item i);
	public void removeItemByID(int i);
}
