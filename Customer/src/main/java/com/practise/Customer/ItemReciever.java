package com.practise.Customer;

import com.practise.Event;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


public class ItemReciever {

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void recieve(Event<ItemDTO> event){
        System.out.println("msg recieved from q from customer:"+event.getType() +" , for id " +event.getObject().getId());
    }

}
