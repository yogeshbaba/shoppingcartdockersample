package com.practise.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.practise.Event;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
@RestController
@RequestMapping("/items")
public class ItemApplication {

	@Autowired
	private AmqpTemplate template;

	@Autowired
	private ItemSender itemSender;

	@Autowired
	private ItemRepository itemRepository;

	private Map<Integer,Item> repo = new HashMap<>();

	public ItemApplication(){
		Item item1 = new Item();
		item1.setId(1);
		item1.setName("paste");
		item1.setQuantity(100);
		item1.setCategory("oral");
		item1.setCost(50);

		Item item2 = new Item();
		item2.setId(2);
		item2.setName("brush");
		item2.setQuantity(10);
		item1.setCategory("oral");
		item2.setCost(20);

		Item item3 = new Item();
		item3.setId(3);
		item3.setName("shampoo");
		item1.setCategory("hair");
		item3.setQuantity(200);
		item3.setCost(90);

		repo.put(item1.getId(), item1);
		repo.put(item2.getId(), item2);
		repo.put(item3.getId(), item3);
	}

	public static void main(String[] args) {
		SpringApplication.run(ItemApplication.class, args);
	}

	@GetMapping("/{id}")
	public Item getItem(@PathVariable Integer id){
		Optional<Item> item = this.itemRepository.findById(id);
		if(item.isPresent()){
			return item.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public void updateItem(@PathVariable Integer id, @RequestBody Item item){
		itemRepository.save(item);
	}

	@PostMapping("/{id}")
	public void addItem(@PathVariable Integer id, @RequestBody Item item){
		System.out.println("adding item : "+id);
		this.itemRepository.save(item);
	}

	@GetMapping()
	public List<Item> getItems(){
		return new ArrayList<>(repo.values());
	}


}
