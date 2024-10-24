package com.project.erpre.repository;

import com.project.erpre.model.dto.ChatDTO;

import java.util.List;

public interface ChatRepositoryCustom {

    // 1. 현재 참여하고 있는 채팅 목록 조회 및 검색
    List<ChatDTO> getChatListByUser(String employeeId, String searchKeyword);

}
