package com.project.erpre.service;

import com.project.erpre.model.dto.ChatDTO;
import com.project.erpre.model.dto.EmployeeDTO;
import com.project.erpre.repository.ChatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.project.erpre.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessengerService {

    private static final Logger logger = LoggerFactory.getLogger(MessengerService.class);

    private final ChatRepository chatRepository;

    @Autowired
    public MessengerService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    // 1. 현재 참여하고 있는 채팅 목록 조회 및 검색
    public List<ChatDTO> getChatListByUser(String employeeId, String searchKeyword){
        return chatRepository.getChatListByUser(employeeId, searchKeyword);
    }


}
