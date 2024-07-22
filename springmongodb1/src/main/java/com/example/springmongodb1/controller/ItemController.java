package com.example.springmongodb1.controller;

import com.example.springmongodb1.model.GroceryItem;
import com.example.springmongodb1.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {
	private final ItemService itemService;
	
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@PostMapping
	public GroceryItem createItem(@RequestBody GroceryItem groceryItem) {
		return itemService.createItem(groceryItem);
	}
	
	@GetMapping("/{id}")
	public GroceryItem getItemById(@PathVariable String id) {
		return itemService.getItemById(id);
	}
	
	@GetMapping
	public List<GroceryItem> getAllItems() {
		return itemService.getAllItems();
	}
	
	@PutMapping("/{id}")
	public GroceryItem updateItem(@PathVariable String id, @RequestBody GroceryItem itemDetails) {
		return itemService.updateItem(id, itemDetails);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable String id) {
		try {
			itemService.deleteItem(id);
			return ResponseEntity.ok().body("Item deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error deleting item");
		}
	}
}
