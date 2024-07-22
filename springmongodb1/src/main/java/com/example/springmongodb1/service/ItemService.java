package com.example.springmongodb1.service;

import com.example.springmongodb1.model.GroceryItem;

import java.util.List;

public interface ItemService {
	GroceryItem createItem(GroceryItem groceryItem);
	
	GroceryItem getItemById(String id);
	
	List<GroceryItem> getAllItems();
	
	GroceryItem updateItem(String id,GroceryItem groceryItem);
	
	void deleteItem(String id);
}
