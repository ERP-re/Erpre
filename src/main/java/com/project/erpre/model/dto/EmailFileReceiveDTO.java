package com.project.erpre.model.dto;

import com.project.erpre.model.entity.EmailReceive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailFileReceiveDTO {

    private Integer emailFileNmR;
    private EmailReceive emailNmR;
    private String emailFileNameR;
    private String emailFileUrlR;
    private Long emailFileSizeR;
    private String emailFileTypeR;
    private String emailFileDelYnR;
    private Timestamp emailFileDelDateR;
}
