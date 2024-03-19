package com.user.springbootcrudrest.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user.springbootcrudrest.model.Item;

// Mark the class as a service. This will allow to handle logic and data manipulation.
@Service
public class ItemRepository {
    private List<Item> items = new ArrayList<>();   // List to hold the items.
    private long idCount = 0;   // Variable to keep the track of id.
    
    // Method to retrieve all the items.
    public List<Item> getItems() {
        return items;
    }

    // Method to create a new item.
    public Item newItem(Item item) {
        item.setId(++idCount);  // Assign a unique id to the new item.
        items.add(item);    // Add the item to the list.
        return item;
    }

    // Method to update and existing item by its id.
    public Item updItem(long id, Item updtadedItem) {
        // Iterate through the list to find the item with the specified id.
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                updtadedItem.setId(id); // Update the id to match the existing item's id.
                items.set(i, updtadedItem); // Replace the existing item with the updatedItem.
            }
        }
        return updtadedItem;
    }

    // Method to delete an existing item by its id.
    public String delItem(long id) {
        // Iterate through the list to find the item with the specified id.
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(i);    // Remove the item from the list.
            }
        }
        return "Item with id: " + id + " deleted succesfully.";
    }
}
