package com.project.erpre.controller;

import com.project.erpre.model.entity.Dispatch;
import com.project.erpre.service.OrderDispatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderdispatch")
public class OrderDispatchController {

    private static final Logger logger = LoggerFactory.getLogger(OrderDispatchController.class); // Logger 선언

    @Autowired
    private OrderDispatchService orderDispatchService;

    //전체 출고정보 조회
    @GetMapping("/getList")
    public List<Dispatch> getList() {
        logger.info("전체 출고 목록 조회");
        return orderDispatchService.getList();
    }

}
