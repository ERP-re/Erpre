package com.project.erpre.service;

import com.project.erpre.model.entity.Dispatch;
import com.project.erpre.repository.OrderDispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDispatchService {

    @Autowired
    private OrderDispatchRepository orderDispatchRepository;

    //전체 출고 목록 조회
    public List<Dispatch> getList() {
        return orderDispatchRepository.findAll();
    }
}
