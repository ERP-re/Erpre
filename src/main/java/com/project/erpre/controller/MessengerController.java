package com.project.erpre.controller;

import com.project.erpre.service.MessengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messengers")
@CrossOrigin(origins = "http://localhost:8787")
public class MessengerController {

    private static final Logger logger = LoggerFactory.getLogger(MessengerController.class);

    private final MessengerService messengerService;

    @Autowired
    public MessengerController(MessengerService messengerService) {
        this.messengerService = messengerService;
    }

}
