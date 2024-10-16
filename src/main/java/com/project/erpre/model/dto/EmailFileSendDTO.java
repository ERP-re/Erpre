package com.project.erpre.model.dto;

import com.project.erpre.model.entity.EmailSend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailFileSendDTO {

    private Integer emailFileNmS;
    private EmailSend emailNmS;
    private String emailFileNameS;
    private String emailFileUrlS;
    private Long emailFileSizeS;
    private String emailFileTypeS;
    private String emailFileDelYnS;
    private Timestamp emailFileDelDateS;
}
