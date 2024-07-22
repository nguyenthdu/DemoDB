package com.example.springmongodb1.service.impl;

import com.example.springmongodb1.model.GroceryItem;
import com.example.springmongodb1.repository.ItemRepository;
import com.example.springmongodb1.service.ItemService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class itemServiceImpl implements ItemService {
	private final ItemRepository itemRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@PostConstruct
	public void init() {
		if(!mongoTemplate.collectionExists(GroceryItem.class)) {
			mongoTemplate.createCollection(GroceryItem.class);
		}
	}
	
	public itemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Override
	public GroceryItem createItem(GroceryItem groceryItem) {
		return itemRepository.save(groceryItem);
	}
	
	@Override
	public GroceryItem getItemById(String id) {
		return itemRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<GroceryItem> getAllItems() {
		return itemRepository.findAll();
	}
	
	@Override
	public GroceryItem updateItem(String id, GroceryItem itemDetails) {
		Optional<GroceryItem> itemOptional = itemRepository.findById(id);
		if(itemOptional.isPresent()) {
			GroceryItem item = itemOptional.get();
			item.setName(itemDetails.getName());
			item.setQuantity(itemDetails.getQuantity());
			item.setCategory(itemDetails.getCategory());
			return itemRepository.save(item);
		}
		return null;
	}
	
	@Override
	public void deleteItem(String id) {
		itemRepository.deleteById(id);
	}
}
