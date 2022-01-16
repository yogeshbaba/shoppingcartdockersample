package com.practise.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.practise.Event;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
@RestController
public class CustomerApplication {

	private Map<Integer, CustomerDTO> repo  = new HashMap<>();
	public CustomerApplication(){
		CustomerDTO dto1 = new CustomerDTO();
		dto1.setId(1);
		dto1.setName("test");
		dto1.setAge(99);
		ItemDTO item1 = new ItemDTO();
		item1.setId(1);
		item1.setName("paste");
		item1.setCost(50);
		item1.setQuantity(2);
		dto1.addOrUpdateCart(item1.getId(), item1);
		repo.put(dto1.getId(),dto1);

	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	@GetMapping("/{id}")
	public CustomerDTO getCustomerInfo(@PathVariable Integer id){
		if(repo.containsKey(id)){
			return repo.get(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{customerId}/cart")
	public ArrayList<ItemDTO> getCart(@PathVariable Integer customerId){
		if(repo.containsKey(customerId)){
			return new ArrayList<>(repo.get(customerId).getCart().values());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/{customerId}/cart")
	public void updateCart(@PathVariable Integer customerId, @RequestBody ItemDTO itemDTO){
		if(repo.containsKey(customerId)){
			repo.get(customerId).addOrUpdateCart(itemDTO.getId(),itemDTO);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
