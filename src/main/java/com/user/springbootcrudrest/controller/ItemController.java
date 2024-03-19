package com.user.springbootcrudrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.springbootcrudrest.model.Item;
import com.user.springbootcrudrest.repository.ItemRepository;

// Mark the class as a RESTful controller.
@RestController
public class ItemController {
    private final ItemRepository itemRepository;    // itemRpository will hold an instance of ItemRepository. This will handle data manipulation within the class.

    // ItemRpository is injected into ItemController.
    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // GET mapping to retrieve all items.
    @GetMapping("/")
    public List<Item> getItems() {
        return itemRepository.getItems();
    }

    // POST mapping to create a new item.
    @PostMapping("/")
    public Item newItem(@RequestBody Item item) {
        return itemRepository.newItem(item);
    }

    // PUT mapping to update an existing item by its id.
    @PutMapping("/{id}")
    public Item updItem(@PathVariable("id") long id, @RequestBody Item updatedItem) {
        return itemRepository.updItem(id, updatedItem);
    }

    // DELETE mapping to delete an existing item by its id.
    @DeleteMapping("/{id}")
    public String delItem(@PathVariable("id") long id) {
        return itemRepository.delItem(id);
    }
}
