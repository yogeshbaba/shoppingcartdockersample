package com.practise.Item;

import com.practise.Event;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


public class ItemReciever {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void recieve(Event<Item> event){
        System.out.println("msg recieved from q :"+event.getType() +" , for id " +event.getObject().getId());
    }

}
