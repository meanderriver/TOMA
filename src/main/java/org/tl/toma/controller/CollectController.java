package org.tl.toma.controller;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.*;
import org.tl.toma.advanced.AdvancedProducer;


@RunWith(SpringRunner.class)
@SpringBootTest
@RestController
public class CollectController {
    @Value("${kafka.topic.advancedtopic}")
    private String topic;

    @Autowired
    private AdvancedProducer producer;
   
    @RequestMapping(value = "/kafkaSend", method = RequestMethod.GET)
    public void sendRecord() {

        producer.send(topic , "this is message from advanced producer" , 10);
    }

}