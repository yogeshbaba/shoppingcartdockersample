package com.practise.Item;

import com.practise.Event;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanout;


    public void send(Event<Item> event){
        rabbitTemplate.convertAndSend(fanout.getName(),"",event);
    }
}
