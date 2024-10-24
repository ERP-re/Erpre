package com.project.erpre.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatDTO {

    private Long chatNo;
    private String chatCreatorId;
    private String chatTitle;
    private LocalDateTime chatCreateDate;
    private LocalDateTime chatUpdateDate;
    private String chatDeleteYn;
    private LocalDateTime chatDeleteDate;

}
