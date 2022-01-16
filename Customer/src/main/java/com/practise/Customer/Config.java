package com.practise.Customer;


import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.core.BindingBuilder.bind;

@Configuration
public class Config {

    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange("item-exchange");
    }

    @Bean
    public Queue autoDeleteQueue2(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding1(FanoutExchange fanout, Queue autoDeleteQueue2){
        return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public ItemReciever reciever(){
        return new ItemReciever();
    }

}
